package com.noodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.dao.mapper.TUserMapper;
import com.noodle.pojo.po.TUser;
import com.noodle.service.IUserService;

public class UserServiceImpl implements IUserService {
	@Autowired
	private TUserMapper userMapper;

	@Override
	public List<TUser> getAllUsers() throws Exception {
		return userMapper.selectByExample(null);
	}

}
