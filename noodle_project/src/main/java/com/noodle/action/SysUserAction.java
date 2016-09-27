package com.noodle.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;
import com.noodle.service.IUserService;

@Controller
@RequestMapping("/user")
public class SysUserAction {
	@Autowired
	private IUserService userService;

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 * @throws ExceptionResultInfo 
	 */
	@RequestMapping("/getAllUsers")
	public @ResponseBody JSON getAllUsers() throws ExceptionResultInfo {
		try {
			int a=1/0;
			return (JSON) JSON.toJSON(userService.getAllUsers());
		} catch (Exception e) {
			ResultInfo resultInfo = new ResultInfo(ResultInfo.TYPE_RESULT_FAIL, 0001, "search all users is fail");
			throw new ExceptionResultInfo(resultInfo);
		}
	};
}
