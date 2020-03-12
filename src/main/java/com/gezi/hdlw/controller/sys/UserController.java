/**
 * 
 */
package com.gezi.hdlw.controller.sys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gezi.hdlw.service.sys.LwAdminService;
import com.gezi.hdlw.util.ResultBean;
import com.gezi.hdlw.vo.sys.LwAdmin;

/**
 * 
 * <p>
 * Title: UserController
 * </p>
 * 
 * <p>
 * Description:管理员管理
 * </p>
 * 
 * @author lixinrong
 * 
 * @date 2019年3月28日
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private LwAdminService lwAdminService;

	/**
	 * 
	 * 
	 * <p>
	 * Title: login
	 * </p>
	 * 
	 * <p>
	 * Description:跳转用户登录页面
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
		if (admin != null) {
			return "redirect:/sys/home";
		}
		return "login";
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: checklogin
	 * </p>
	 * 
	 * <p>
	 * Description:用户登录
	 * </p>
	 * 
	 * @param req
	 * @param res
	 * @param username
	 * @param password
	 * @param remember
	 * @return
	 */
	@RequestMapping("/checklogin")
	@ResponseBody
	public ResultBean checklogin(HttpServletRequest req, HttpServletResponse res, String username, String password,
			boolean remember) {
		System.out.println(password);
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return new ResultBean(false, "参数不能为空");
		}
		try {
			Subject subject = SecurityUtils.getSubject();
			// md5加密
//			password = DigestUtils.md5DigestAsHex(password.getBytes());
			UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
			subject.login(token);
		} catch (UnknownAccountException e) {
			return new ResultBean(false, e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return new ResultBean(false, e.getMessage());
		} catch (LockedAccountException e) {
			return new ResultBean(false, e.getMessage());
		} catch (AuthenticationException e) {
			return new ResultBean(false, "账户验证失败");
		}

		try {
			if (remember) {
				Cookie usernameCookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
				Cookie passwordCookie = new Cookie("password", password);
				Cookie rememberCookie = new Cookie("remember", remember + "");
				/* 设置cookie有效期两周 */
				usernameCookie.setMaxAge(60 * 60 * 24 * 14);
				passwordCookie.setMaxAge(60 * 60 * 24 * 14);
				rememberCookie.setMaxAge(60 * 60 * 24 * 14);
				res.addCookie(usernameCookie);
				res.addCookie(passwordCookie);
				res.addCookie(rememberCookie);
			} else {
				Cookie[] cookies = req.getCookies();
				for (int i = 0; i < cookies.length; i++) {
					if ("username".equals(cookies[i].getName())) {
						cookies[i].setMaxAge(0);
					} else if ("password".equals(cookies[i].getName())) {
						cookies[i].setMaxAge(0);
					} else if ("remember".equals(cookies[i].getName())) {
						cookies[i].setMaxAge(0);
					}
					res.addCookie(cookies[i]);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResultBean(true, true, 0);
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: personalDataView
	 * </p>
	 * 
	 * <p>
	 * Description:跳转显示用户信息页面
	 * </p>
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/personalDataView")
	public String personalDataView(HttpServletRequest req) {
		LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
		if (admin == null) {
			return "error";
		}
		req.setAttribute("admin", admin);
		return "sys/user/info";
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: personalData
	 * </p>
	 * 
	 * <p>
	 * Description:修改用户信息
	 * </p>
	 * 
	 * @param req
	 * @param lwAdmin
	 * @return
	 */
	@RequestMapping("/personalData")
	@ResponseBody
	public ResultBean personalData(HttpServletRequest req, LwAdmin lwAdmin) {
		int i = lwAdminService.saveOrUpdate(lwAdmin);
		if (i > 0) {
			return new ResultBean(true, true);
		}
		return new ResultBean(false);
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: changePwdView
	 * </p>
	 * 
	 * <p>
	 * Description:跳转修改用户密码页面
	 * </p>
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/changePwdView")
	public String changePwdView(HttpServletRequest req) {
		return "sys/user/password";
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: changePwd
	 * </p>
	 * 
	 * <p>
	 * Description:修改用户密码
	 * </p>
	 * 
	 * @param req
	 * @param oldPassWord
	 * @param newPassWord
	 * @return
	 */
	@RequestMapping("/changePwd")
	@ResponseBody
	public ResultBean changePwd(HttpServletRequest req, String oldPassWord, String newPassWord) {
		if (oldPassWord == null || oldPassWord.trim().isEmpty() || newPassWord == null
				|| newPassWord.trim().isEmpty()) {
			return new ResultBean(false);
		} else {
			LwAdmin admin = (LwAdmin) SecurityUtils.getSubject().getPrincipal();
			if (oldPassWord.equals(admin.getPassword())) {
				admin.setPassword(newPassWord);
				int i = lwAdminService.saveOrUpdate(admin);
				if (i > 0) {
					return new ResultBean(true, true);
				}
			}
			return new ResultBean(false);
		}
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: forgetView
	 * </p>
	 * 
	 * <p>
	 * Description:跳转用户找回密码页面
	 * </p>
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/forgetView")
	public String forgetView(HttpServletRequest req) {
		return "sys/user/forget";
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: loginOut
	 * </p>
	 * 
	 * <p>
	 * Description:用户退出登录
	 * </p>
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/loginOut")
	@ResponseBody
	public ResultBean loginOut(HttpServletRequest req) {
		SecurityUtils.getSubject().logout();
		return new ResultBean(true, true);
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: sessionOut
	 * </p>
	 * 
	 * <p>
	 * Description:seesion超时跳转页面
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/sessionOut")
	public String sessionOut() {
		return "common/sessionOut";
	}
}
