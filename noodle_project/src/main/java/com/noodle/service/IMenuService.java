package com.noodle.service;

import java.util.List;

import com.noodle.pojo.po.TMenu;
import com.noodle.pojo.vo.Menu;
import com.noodle.process.result.ExceptionResultInfo;

public interface IMenuService {
	public List<Menu> getAllMenusByuserId(int id)throws ExceptionResultInfo;

	public List<TMenu> findPermissionListByUserid(int parseInt)throws ExceptionResultInfo;
}
