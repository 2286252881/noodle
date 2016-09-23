package com.noodle.service;

import java.util.List;

import com.noodle.pojo.po.TUser;

public interface IUserService {
	public List<TUser> getAllUsers()throws Exception;
}
