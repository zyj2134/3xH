package com.duapp.xxxHolic.action;

import com.duapp.xxxHolic.utils.Constant;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class ContactController extends Controller {

	public void index() {
		setAttr("step", Constant.STEP_ONE_INSTRUCTIONS);
		setAttr("type", Constant.QUESTION_TYPE_NAME);
		setAttr("question", Constant.STEP_ONE_QUESTION.replaceAll("？|\\?", ""));
		setAttr("tips", Constant.STEP_ONE_TIPS);
		setAttr("action", Constant.STEP_ONE_ACTION);
		removeSessionAttr(Constant.STEP_TWO_QUESTION_ID);
		removeSessionAttr(Constant.GROUP_ID);
		render("/contact/contact.jsp");
	}

	public void step1_submit() {
		String answer = getPara("answer","");
		Integer err_count = (Integer) getSessionAttr(Constant.ANSWER_ERR_COUNT);
		err_count = (err_count == null ? 0 : err_count);
		String ret = "";
		if (err_count >= Constant.ANSWER_ERR_COUNT_LIMT) {
			String randomCode = getPara("randomCode","");
			if ("".equals(randomCode)) {
				ret = "您还未填写验证码";
			} else if (!randomCode.toUpperCase().equals(getSessionAttr(Constant.RANDOM_CODE_KEY))) {
				ret = "您填写的验证码错误";
			}
		}
		if ("".equals(ret)) {
			if ("".equals(answer)) {
				ret = "您还未填写真实姓名";
			} else {
				Record member = Db.findFirst("select * from member where username = ? order by total_use,daily_use asc", answer);
				if (member == null) {
					ret = "您填写的真实姓名暂时不能获取联系方式，如有意见，可以使用意见反馈功能";
				} else {
					if (member.getInt("daily_use") >= Constant.NAME_DAILY_USE_COUNT_LIMT && err_count < Constant.ANSWER_ERR_COUNT_LIMT) {
						err_count = Constant.ANSWER_ERR_COUNT_LIMT - 1;
						ret = "该姓名当日使用次数较多，此次提交需要您填写验证码";
					} else {
						Db.update("update member set total_use=total_use+1,daily_use=daily_use+1 where id=?", member.getNumber("id"));
						Record question = Db.findFirst("select * from question where group_id = ? order by total_use,daily_use asc", member.getNumber("group_id"));
						setSessionAttr(Constant.STEP_TWO_QUESTION_ID, question.getNumber("id"));
						setSessionAttr(Constant.GROUP_ID, member.getNumber("group_id"));
						setAttr("question", question.getStr("subject").replaceAll("？|\\?", ""));
						setAttr("tips", question.getStr("hint"));
						if (question.getInt("daily_use") >= Constant.QUESTION_DAILY_USE_COUNT_LIMT) {
							setSessionAttr(Constant.ANSWER_ERR_COUNT, Constant.ANSWER_ERR_COUNT_LIMT);
						} else {
							removeSessionAttr(Constant.ANSWER_ERR_COUNT);
						}
					}
				}
			}
		}
		setAttr("type", Constant.QUESTION_TYPE_NAME);
		if (!"".equals(ret)) {
			keepPara("answer");
			setAttr("step", Constant.STEP_ONE_INSTRUCTIONS);
			setAttr("question", Constant.STEP_ONE_QUESTION.replaceAll("？|\\?", ""));
			setAttr("tips", Constant.STEP_ONE_TIPS);
			setAttr("action", Constant.STEP_ONE_ACTION);
			setAttr("err", ret);
			setSessionAttr(Constant.ANSWER_ERR_COUNT, err_count + 1);
			removeSessionAttr(Constant.STEP_TWO_QUESTION_ID);
		} else {
			setAttr("step", Constant.STEP_TWO_INSTRUCTIONS);
			setAttr("action", Constant.STEP_TWO_ACTION);
		}
		render("/contact/contact.jsp");
	}
	
	public void step2_submit() {
		if (getSessionAttr(Constant.STEP_TWO_QUESTION_ID) == null) {
			redirect("/contact/");
			return;
		}
		String answer = getPara("answer","");
		Integer err_count = (Integer) getSessionAttr(Constant.ANSWER_ERR_COUNT);
		err_count = (err_count == null ? 0 : err_count);
		String ret = "";
		if (err_count >= Constant.ANSWER_ERR_COUNT_LIMT) {
			String randomCode = getPara("randomCode","");
			if ("".equals(randomCode)) {
				ret = "您还未填写验证码";
			} else if (!randomCode.toUpperCase().equals(getSessionAttr(Constant.RANDOM_CODE_KEY))) {
				ret = "您填写的验证码错误";
			}
		}
		if ("".equals(ret)) {
			if ("".equals(answer)) {
				ret = "您还未回答问题";
			} else {
				Record answer_record = Db.findFirst("select 1 from answer where question_id = ? and answer_key = ?", getSessionAttr(Constant.STEP_TWO_QUESTION_ID), answer);
				if (answer_record == null) {
					ret = "您填写的答案错误";
				} else {
					Record contact = Db.findFirst("select mobile from contact order by id desc");
					Db.update("update question set total_use=total_use+1,daily_use=daily_use+1 where id=?", getSessionAttr(Constant.STEP_TWO_QUESTION_ID));
					setAttr("type", Constant.CONTACT_TYPE_NAME);
					setAttr("contact", contact.getStr("mobile"));
					setAttr("question", contact.getStr("mobile"));
				}
			}
		}
		if (!"".equals(ret)) {
			keepPara("answer");
			Record question = Db.findFirst("select * from question where group_id = ? order by total_use,daily_use asc", getSessionAttr(Constant.GROUP_ID));
			setSessionAttr(Constant.STEP_TWO_QUESTION_ID, question.getNumber("id"));
			setAttr("step", Constant.STEP_TWO_INSTRUCTIONS);
			setAttr("question", question.getStr("subject").replaceAll("？|\\?", ""));
			setAttr("tips", question.getStr("hint"));
			setAttr("type", Constant.QUESTION_TYPE_NAME);
			setAttr("action", Constant.STEP_TWO_ACTION);
			setAttr("err", ret);
			setSessionAttr(Constant.ANSWER_ERR_COUNT, err_count + 1);
		} else {
			setAttr("step", Constant.STEP_GET_CONTACT);
			removeSessionAttr(Constant.STEP_TWO_QUESTION_ID);
			removeSessionAttr(Constant.GROUP_ID);
			removeSessionAttr(Constant.ANSWER_ERR_COUNT);
		}
		render("/contact/contact.jsp");
	}
}
