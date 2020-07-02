# likspace-cloud-business
# likspace企业模块
ErrorCodeEnum错误枚举说明
规则： 
服务名称+错误类型+错误代码
9999：全局异常处理
6666：参数校验
~~~
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

~~~