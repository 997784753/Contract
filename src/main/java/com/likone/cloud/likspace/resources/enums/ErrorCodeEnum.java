package com.likone.cloud.likspace.resources.enums;


/**
 * The class Error code enum.
 *
 * @author paascloud.net @gmail.com
 */
public enum ErrorCodeEnum {
	/**
	 * PRODUCT 99990100 error code enum.
	 */
	PRODUCT99990100(9999100, "参数异常"),
	/**
	 * PRODUCT 99990401 error code enum.
	 */
	PRODUCT99990401(99990401, "无访问权限"),
	/**
	 * PRODUCT 000500 error code enum.
	 */
	PRODUCT99990500(500, "未知异常"),
	/**
	 * PRODUCT 000403 error code enum.
	 */
	PRODUCT99990403(9999403, "无权访问"),
	/**
	 * PRODUCT 000404 error code enum.
	 */
	PRODUCT9999404(9999404, "找不到指定资源"),
	/**
	 * PRODUCT 99990001 error code enum.
	 */
	PRODUCT99990001(99990001, "注解使用错误"),
	/**
	 * PRODUCT 99990002 error code enum.
	 */
	PRODUCT99990002(99990002, "微服务不在线,或者网络超时"),
	/**
	 * Uac 10010001 error code enum.
	 */
	PRODUCT10010001(10010001, "会话超时,请刷新页面重试"),

	/**
	 * null Object  Obj 前缀 66660001 叠加
	 */
	PRODUCT66660001(66660001,"参数id不存在");
	private int code;
	private String msg;
	/**
	 * Msg string.
	 *
	 * @return the string
	 */
	public String msg() {
		return msg;
	}

	/**
	 * Code int.
	 *
	 * @return the int
	 */
	public int code() {
		return code;
	}

	ErrorCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * Gets enum.
	 *
	 * @param code the code
	 *
	 * @return the enum
	 */
	public static ErrorCodeEnum getEnum(int code) {
		for (ErrorCodeEnum ele : ErrorCodeEnum.values()) {
			if (ele.code() == code) {
				return ele;
			}
		}
		return null;
	}
}
