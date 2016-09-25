package com.noodle.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.noodle.pojo.po.TMenu;
import com.noodle.pojo.vo.Menu;
import com.noodle.process.result.ExceptionResultInfo;

public interface CustomMenuMapper {
	/**
	 * 用户菜单
	 * @param id
	 * @return
	 * @throws ExceptionResultInfo
	 */
	public List<Menu> getAllMenusByuserId(@Param("id")int id)throws ExceptionResultInfo;
	/**
	 * 用户菜的那下的权限
	 * @return
	 * @throws ExceptionResultInfo
	 */
	public List<TMenu> findPermissionListByUserid(@Param("id")int id)throws ExceptionResultInfo;
}
