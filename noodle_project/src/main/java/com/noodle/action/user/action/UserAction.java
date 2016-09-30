package com.noodle.action.user.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;
import com.noodle.service.IUserService;

/**
 * 如果使用shiro权限注解需要手动捕获
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService userService;
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 * @throws ExceptionResultInfo 
	 */
	@RequestMapping("/user.action")
	@RequiresPermissions("user:xx")
	public @ResponseBody JSON getAllUsers() throws ExceptionResultInfo {
		try {
			return (JSON) JSON.toJSON(userService.getAllUsers());
		} catch (Exception e) {
			ResultInfo resultInfo = new ResultInfo(ResultInfo.TYPE_RESULT_FAIL, 0001, "search all users is fail");
			throw new ExceptionResultInfo(resultInfo);
		}
	};
}
