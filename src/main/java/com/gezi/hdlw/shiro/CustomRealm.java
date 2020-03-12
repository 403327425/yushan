package com.gezi.hdlw.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gezi.hdlw.service.sys.LwAdminService;
import com.gezi.hdlw.service.sys.LwRolesMenusService;
import com.gezi.hdlw.vo.sys.LwAdmin;
import com.gezi.hdlw.vo.sys.LwRoles;
import com.gezi.hdlw.vo.sys.LwRolesMenusKey;

public class CustomRealm extends AuthorizingRealm {
	@Resource
	private LwAdminService lwAdminService;
	@Resource
	private LwRolesMenusService lwRolesMenusService;

	private static Logger logger = LoggerFactory.getLogger(CustomRealm.class);

	public CustomRealm() {
		logger.info("CustomRealm====================");
	}

	@Override
	public String getName() {
		return "CustomRealm";
	}

	/**
	 * realm授权方法 从输入参数principalCollection得到身份信息 根据身份信息到数据库查找权限信息 将权限信息添加给授权信息对象 返回
	 * 授权信息对象(判断用户访问url是否在权限信息中没有体现)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		LwAdmin admin = (LwAdmin) principalCollection.getPrimaryPrincipal();
		LwRolesMenusKey record = new LwRolesMenusKey();
		record.setRole(new LwRoles(admin.getRoleId()));
		LwRoles roles = lwRolesMenusService.getRole(record);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(roles.getPermsSet());
		return info;
	}

	/**
	 * 表单认证过滤器认证时会调用自定义Realm的认证方法进行认证，成功回到index.do，再跳转到index.jsp页面
	 *
	 * 前提：表单认证过滤器收集和组织用户名和密码信息封装为token对象传递给此方法
	 *
	 * token:封装了身份信息和凭证信息 2步骤：比对身份 信息；比对凭证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		// 查询用户信息
		LwAdmin admin = lwAdminService.getAdminByWhere(new LwAdmin(username));
		// 账号不存在
		if (admin == null) {
			throw new UnknownAccountException("账号不存在!");
		}
		// 密码错误
		if (!password.equals(admin.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确!");
		}

		// 账号未分配角色
		if (admin.getRoleId() == null || admin.getRoleId() == 0) {
			throw new UnknownAccountException("账号未分配角色!");
		}
		password = new Md5Hash(password).toString();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin, password, getName());
		return info;
	}
}
