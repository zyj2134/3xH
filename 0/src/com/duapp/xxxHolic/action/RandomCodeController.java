package com.duapp.xxxHolic.action;

import java.io.IOException;
import java.io.OutputStream;

import com.duapp.xxxHolic.utils.Constant;
import com.duapp.xxxHolic.utils.RandomCodeUtil;
import com.jfinal.core.Controller;
//import com.jfinal.ext.render.CaptchaRender;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class RandomCodeController extends Controller {
	
	public void index() {
		getResponse().setContentType("image/jpeg");
		OutputStream os;
		try {
			os = getResponse().getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(RandomCodeUtil.getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		setSessionAttr(Constant.RANDOM_CODE_KEY, RandomCodeUtil.getRandomCode().toUpperCase());
//		render(new CaptchaRender(Constant.RANDOM_CODE_KEY));
		renderNull();
	}
}
