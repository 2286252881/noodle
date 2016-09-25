package com.noodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.dao.mapper.CustomMenuMapper;
import com.noodle.pojo.po.TMenu;
import com.noodle.pojo.vo.Menu;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.service.IMenuService;
import com.noodle.shiro.CustomRealm;

public class MenuServiceImpl implements IMenuService {

	@Autowired
	private CustomMenuMapper menuMapper;
	// 注入realm

	@Override
	public List<Menu> getAllMenusByuserId(int id) throws ExceptionResultInfo {
		return menuMapper.getAllMenusByuserId(id);
	}

	@Override
	public List<TMenu> findPermissionListByUserid(int id) throws ExceptionResultInfo {
		return menuMapper.findPermissionListByUserid(id);
	}
}
