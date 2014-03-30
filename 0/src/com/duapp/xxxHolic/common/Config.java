package com.duapp.xxxHolic.common;

import com.duapp.xxxHolic.utils.ConfigUtil;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.route.AutoBindRoutes;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.render.ViewType;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * API引导式配置
 */
public class Config extends JFinalConfig{

	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用getProperty(...)获取值
		ConfigUtil.loadConfig(loadPropertyFile("classes/com/duapp/xxxHolic/common/conn.properties"));
//		me.setDevMode(getPropertyToBoolean("devMode", false));
		me.setDevMode(true);
	    me.setViewType(ViewType.JSP);
	    me.setError404View("/error/404.jsp");
	    me.setError500View("/error/500.jsp");
	}
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/", MainController.class);
		me.add(new AutoBindRoutes());//自动注册路由，默认规则例：TreeMenuController注册路由为/treeMenu，首字母小写
	}

	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl(getProperty("url"));
	    ds.setUser(getProperty("user"));
	    ds.setPassword(getProperty("password"));
		// 配置ActiveRecord插件
//		ActiveRecordPlugin arp = new ActiveRecordPlugin(ds);
//		me.add(arp);
		//自动绑定表【有了它就不再需要 ActiveRecordPlugin了】
		AutoTableBindPlugin atbp = new AutoTableBindPlugin(ds);
		me.add(atbp);
		atbp.setContainerFactory(new CaseInsensitiveContainerFactory());//忽略数据库字段大小写
	}

	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}

	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
	
	public void afterJFinalStart(){
		
	}
	
	public void beforeJFinalStop(){
		
	}

	/**
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     */
    public static void main(String[] args) {
        JFinal.start("WebRoot", 8080, "/", 10);
    }
}