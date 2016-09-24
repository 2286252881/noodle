package com.noodle.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.pojo.po.ActiveUser;
import com.noodle.pojo.po.TMenu;
import com.noodle.pojo.po.TUser;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.service.IUserService;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;

	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//第一步从token中取出身份凭证
				String username=(String) token.getPrincipal();
				TUser tuser=null;
				try {
					tuser=userService.findSysUserByUserName(username);//只用用户名是因为密码是md5加密的，待对比。。。。。
				} catch (ExceptionResultInfo e) {
					e.printStackTrace();
				}
				//如果根据用户没查到用户信息就不用做处理了
				if(tuser==null){
					return null;//放行未认证通过
				}
				
				//如果根据用户查到用户信息,就开始认证用户(这里认证主要是对比加密后的密码)
				String password=tuser.getPassword();
				/*String salt=tuser.getSalt();*/
				String salt=tuser.getUsername();
				
				ActiveUser activeUser=new ActiveUser();
				activeUser.setUsername(tuser.getUsername());
				List<TMenu> menus=this.menus();//这一步可以通过userService去获取tuser(userId)用户对应的菜单
				activeUser.setMenus(menus);
				SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(salt), this.getName());
				return simpleAuthenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return null;
	}

	/**
	 * 模拟菜单
	 * 
	 * @return
	 */
	private List<TMenu> menus() {
		List<TMenu> menus = new ArrayList<TMenu>();
		TMenu menu1 = new TMenu();
		menu1.setMenuname("菜单-lol");
		TMenu menu2 = new TMenu();
		menu2.setMenuname("菜单-一起看");
		TMenu menu3 = new TMenu();
		menu3.setMenuname("菜单-户外");
		TMenu menu4 = new TMenu();
		menu4.setMenuname("菜-新秀");
		return menus;
	}

}
