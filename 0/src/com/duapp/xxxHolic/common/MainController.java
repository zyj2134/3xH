package com.duapp.xxxHolic.common;

import com.jfinal.core.Controller;

/**
 * CommonController
 */
public class MainController extends Controller {
	
	public void index() {
		String url = "/index.jsp";
		render(url);
	}

//	public void test() {
//		try {
//			BAECacheUtils.put("test", getPara("test"));
//		} catch (Exception e) {
//			e.printStackTrace();
//			BAECacheUtils.put("test", "123123123123");
//		}
//		renderJson("back", BAECacheUtils.get("test"));
//	}
}
