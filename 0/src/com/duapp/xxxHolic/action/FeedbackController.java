package com.duapp.xxxHolic.action;

import java.util.Date;

import com.duapp.xxxHolic.validator.FeedbackValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class FeedbackController extends Controller {
	
	public void index(){
		render("/feedback/feedback.jsp");
	}
	
	@Before(FeedbackValidator.class)
	public void submit(){
		boolean flag;
		String content = getPara("content");
		String email = getPara("email");
		Record feedback = new Record()
			.set("user_ip", getRequest().getRemoteAddr())
			.set("date", new Date())
			.set("content", content)
			.set("email", email);
		flag = Db.save("feedback", feedback);
		setAttr("ret", flag);
		render("/feedback/feedback.jsp");
	}
}
