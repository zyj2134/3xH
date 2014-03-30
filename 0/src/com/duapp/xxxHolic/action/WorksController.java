package com.duapp.xxxHolic.action;

import com.jfinal.core.Controller;

public class WorksController extends Controller {
	
	public void index(){
		String url = getPara();
		render("/works/" + url + ".jsp");
	}

}
