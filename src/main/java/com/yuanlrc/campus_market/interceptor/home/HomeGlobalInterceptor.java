package com.yuanlrc.campus_market.interceptor.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yuanlrc.campus_market.service.common.FriendLinkService;
import com.yuanlrc.campus_market.service.common.GoodsCategoryService;
import com.yuanlrc.campus_market.util.StringUtil;

/**
 * 前台全局拦截器
 * @author Administrator
 *
 */
@Component
public class HomeGlobalInterceptor implements HandlerInterceptor{

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private FriendLinkService friendLinkService;
	@Override
	public boolean  preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

		if(!StringUtil.isAjax(request)){
			//若不是ajax请求，则将菜单信息放入页面模板变量
			request.setAttribute("goodsCategorys", goodsCategoryService.findAll());
			request.setAttribute("friendLinkList", friendLinkService.findList(8));
		}
		return true;
	}
}
