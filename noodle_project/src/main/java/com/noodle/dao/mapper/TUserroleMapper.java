package com.noodle.dao.mapper;

import com.noodle.pojo.po.TUserrole;
import com.noodle.pojo.po.TUserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserroleMapper {
    int countByExample(TUserroleExample example);

    int deleteByExample(TUserroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserrole record);

    int insertSelective(TUserrole record);

    List<TUserrole> selectByExample(TUserroleExample example);

    TUserrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserrole record, @Param("example") TUserroleExample example);

    int updateByExample(@Param("record") TUserrole record, @Param("example") TUserroleExample example);

    int updateByPrimaryKeySelective(TUserrole record);

    int updateByPrimaryKey(TUserrole record);
}