package com.easytoolsoft.easyadmin.web.filters;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.easytoolsoft.easyadmin.MembershipFacade;
import com.easytoolsoft.easyadmin.web.Constants;

public class MembershipFilter extends PathMatchingFilter {
	@Resource
	private MembershipFacade membershipFacade;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		String account = (String) SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(Constants.CURRENT_USER, membershipFacade.getUser(account));
		return true;
	}
}
