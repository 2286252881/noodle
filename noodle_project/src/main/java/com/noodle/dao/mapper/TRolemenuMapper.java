package com.noodle.dao.mapper;

import com.noodle.pojo.po.TRolemenu;
import com.noodle.pojo.po.TRolemenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRolemenuMapper {
    int countByExample(TRolemenuExample example);

    int deleteByExample(TRolemenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRolemenu record);

    int insertSelective(TRolemenu record);

    List<TRolemenu> selectByExample(TRolemenuExample example);

    TRolemenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRolemenu record, @Param("example") TRolemenuExample example);

    int updateByExample(@Param("record") TRolemenu record, @Param("example") TRolemenuExample example);

    int updateByPrimaryKeySelective(TRolemenu record);

    int updateByPrimaryKey(TRolemenu record);
}