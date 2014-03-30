package com.duapp.xxxHolic.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class FeedbackValidator extends Validator {

	@Override
	protected void handleError(Controller c) {
		c.keepPara("content");
		c.keepPara("email");
		c.render("/feedback/feedback.jsp");
	}

	@Override
	protected void validate(Controller c) {
		validateRequiredString("content", "formContent_err", "发送内容不能为空哦");
		validateString("content", false, 0, 500, "formContent_err", "发送内容不能超过500字哦");
		if (!"".equals(c.getPara("email"))) {
			validateString("email", 0, 35, "formEmail_err", "邮箱地址长度超出限制，请您换个长度35以内的邮箱再试");
			validateEmail("email", "formEmail_err", "请输入正确邮箱地址");
		}
	}

}
