package com.noodle.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.noodle.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService userService;
	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	@RequestMapping("/getAllUsers")
	public JSON getAllUsers(){
		try {
			return  (JSON) JSON.toJSON(userService.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("getAllUsers获取所有用户信息失败!");
		}
	};
}
