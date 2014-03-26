package com.reagan.wxpt.service.api;

import javax.servlet.http.HttpServletRequest;

public interface IWXPortService {

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return xml
	 */
	public String processRequest(HttpServletRequest request);
}
