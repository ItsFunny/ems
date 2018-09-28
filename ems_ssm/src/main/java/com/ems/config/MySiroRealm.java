
package com.ems.config;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.ems.model.Authority;
import com.ems.model.SysPermission;
import com.ems.model.User;
import com.ems.service.AuthorityService;
import com.ems.service.SysPermissionService;
import com.ems.service.UserService;

public class MySiroRealm extends AuthorizingRealm
{

	@Override
	public void onLogout(PrincipalCollection principals)
	{
		System.out.println("退出登陆了");
		super.onLogout(principals);
	}

	@Autowired
	UserService userService;
	@Autowired
	AuthorityService authorityService;
	@Autowired
	SysPermissionService sysPermissionService;

	// @Autowired
	// RedisTemplate redisTemplate;
	// @Autowired
	// RedisConnectionFactory redisConnectionFactory;
	// 身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
	{

		// 获取用户输入的身份账号
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (username == null || "".equals(username) || password == null || "".equals(password))
		{
			try
			{
				throw new AccountNotFoundException();
			} catch (AccountNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = userService.getUserByRoleId(username);
		if (!user.getPassword().equals(password))
		{
			throw new AuthenticationException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
				this.getName());

		// SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		User user = (User) principals.getPrimaryPrincipal();
		Authority authority = authorityService.getAuthById(user.getRoleId());
		authorizationInfo.addRole(authority.getName());
		List<SysPermission> sysPermissionLists = new ArrayList<SysPermission>();
		sysPermissionLists = sysPermissionService.getPermissionsByAuthId(user.getAuthId());
		for (SysPermission sysPermission : sysPermissionLists)
		{
			authorizationInfo.addStringPermission(sysPermission.getPermission());
		}
		return authorizationInfo;
	}
}
