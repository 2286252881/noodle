package com.noodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.dao.mapper.TUserMapper;
import com.noodle.pojo.po.TUser;
import com.noodle.pojo.po.TUserExample;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;
import com.noodle.process.result.ResultUtil;
import com.noodle.service.IUserService;

public class UserServiceImpl implements IUserService {
	@Autowired
	private TUserMapper userMapper;

	@Override
	public List<TUser> getAllUsers() throws ExceptionResultInfo {
		TUserExample tuserExample=new TUserExample();
		TUserExample.Criteria criteria=tuserExample.createCriteria();
		return userMapper.selectByExample(tuserExample);
	}

	@Override
	public TUser findSysUserByUserName(String userName) throws ExceptionResultInfo {
		TUserExample tuserExample=new TUserExample();
		TUserExample.Criteria criteria=tuserExample.createCriteria();
		criteria.andUsernameEqualTo(userName);
		criteria.andFlagEqualTo(1);
		List<TUser> list = userMapper.selectByExample(tuserExample);
		TUser user=new TUser();
		if(list!=null && list.size()==1){
			user=list.get(0);
		}	
		return user;
	}

}
