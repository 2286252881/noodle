package com.noodle.service;

import java.util.List;

import com.noodle.pojo.po.TUser;
import com.noodle.process.result.ExceptionResultInfo;

public interface IUserService {
	public List<TUser> getAllUsers()throws ExceptionResultInfo;
	public TUser findSysUserByUserName(String userName)throws ExceptionResultInfo;
}
