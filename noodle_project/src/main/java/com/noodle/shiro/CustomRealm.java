package com.noodle.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.pojo.po.ActiveUser;
import com.noodle.pojo.po.TMenu;
import com.noodle.pojo.po.TUser;
import com.noodle.pojo.vo.Menu;
import com.noodle.service.IMenuService;
import com.noodle.service.IUserService;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 第一步从token中取出身份凭证
		String username = (String) token.getPrincipal();
		TUser tuser = null;
			try {
				tuser = userService.findSysUserByUserName(username);
			} catch (Exception e) {
				e.printStackTrace();
			}// 只用用户名是因为密码是md5加密的，待对比。。。。。
		// 如果根据用户没查到用户信息就不用做处理了
		if (tuser == null) {
			return null;// 放行未认证通过
		}

		// 如果根据用户查到用户信息,就开始认证用户(这里认证主要是对比加密后的密码)
		String password = tuser.getPassword();
		/* String salt=tuser.getSalt(); */
		String salt = tuser.getUsername();

		ActiveUser activeUser = new ActiveUser();
		activeUser.setUsername(tuser.getUsername());
		activeUser.setUserid(tuser.getId().toString());
		List<Menu> menus = null;
		// this.menus();//这一步可以通过userService去获取tuser(userId)用户对应的菜单
			try {
				menus = menuService.getAllMenusByuserId(tuser.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		activeUser.setMenus(menus);
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password,
				ByteSource.Util.bytes(salt), this.getName());
		return simpleAuthenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从principals获取主身份信息
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		List<TMenu> tpermissionList = new ArrayList<TMenu>();
		try {
			tpermissionList = menuService.findPermissionListByUserid(Integer.parseInt(activeUser.getUserid()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> permissions = new ArrayList<String>();
		for (TMenu tpermission : tpermissionList) {
			permissions.add(tpermission.getMenutext());
		}
		if (permissions.size() == 0) {
			permissions.add("no_permissions");
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

	// 清除缓存
//	public void clearCached() {
//		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
//		super.clearCache(principals);
//	}

	/**
	 * 模拟菜单
	 * 
	 * @return
	 */
	private List<Menu> menus() {
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu1 = new Menu();
		menu1.setMenuname("菜单-lol");
		Menu menu2 = new Menu();
		menu2.setMenuname("菜单-一起看");
		Menu menu3 = new Menu();
		menu3.setMenuname("菜单-户外");
		Menu menu4 = new Menu();
		menu4.setMenuname("菜-新秀");
		return menus;
	}

}
