package com.duapp.xxxHolic.utils;

public class Constant {

	/**
	 * 第一步提交处理的action
	 */
	public static final String STEP_ONE_ACTION = "contact/step1_submit";
	
	/**
	 * 第一步说明
	 */
	public static final String STEP_ONE_INSTRUCTIONS = "第一步：填写您的真实姓名";

	/**
	 * 第一步问题
	 */
	public static final String STEP_ONE_QUESTION = "您的真实姓名是?";

	/**
	 * 第一步提示说明
	 */
	public static final String STEP_ONE_TIPS = "请填写您的真实姓名，按回车提交";

	/**
	 * 用户所在的分组ID session
	 */
	public static final String GROUP_ID = "group_id";

	/**
	 * 第二步问题ID
	 */
	public static final String STEP_TWO_QUESTION_ID = "question_id";

	/**
	 * 第二步提交处理的action
	 */
	public static final String STEP_TWO_ACTION = "contact/step2_submit";

	/**
	 * 第二步说明
	 */
	public static final String STEP_TWO_INSTRUCTIONS = "第二步：回答一个至两个简单问题";

	/**
	 * 问题回答错误次数session
	 */
	public static final String ANSWER_ERR_COUNT = "answer_err_count";

	/**
	 * 一个问题连续回答错误免验证码的次数上限
	 */
	public static final int ANSWER_ERR_COUNT_LIMT = 3;

	/**
	 * 一个姓名每日使用免验证码的次数上限
	 */
	public static final int NAME_DAILY_USE_COUNT_LIMT = 6;

	/**
	 * 一个问题每日回答正确免验证码的次数上限
	 */
	public static final int QUESTION_DAILY_USE_COUNT_LIMT = 50;

	/**
	 * 类型：问题
	 */
	public static final String QUESTION_TYPE_NAME = "问题";

	/**
	 * 类型：联系方式
	 */
	public static final String CONTACT_TYPE_NAME = "联系方式";

	/**
	 * 成功获取联系方式
	 */
	public static final String STEP_GET_CONTACT = "请记录好联系方式";
	
	/**
	 * 验证码session
	 */
	public static final String RANDOM_CODE_KEY = "random_code";
}
