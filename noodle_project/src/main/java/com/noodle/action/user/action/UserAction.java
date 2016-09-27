package com.noodle.action.user.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 如果使用shiro权限注解需要手动捕获
 * @author Administrator
 *
 */
@Controller
public class UserAction {
	@RequestMapping("/user/user.action")
	@RequiresPermissions("user:xxx")
	public String  addUser(HttpServletRequest request){
		return "/base/user/addUser";
	}
}
