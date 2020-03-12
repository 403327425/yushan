package com.gezi.hdlw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gezi.hdlw.vo.sys.LwAdmin;

/**
 * 
 * <p>
 * Title: SystemSessionInterceptor
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年4月22日
 * 
 */
public class SystemSessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
		if (admin == null) {
			response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/user/sessionOut");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
