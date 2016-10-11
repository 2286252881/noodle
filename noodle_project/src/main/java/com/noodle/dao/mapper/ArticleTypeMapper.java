package com.noodle.dao.mapper;

import com.noodle.pojo.po.ArticleType;
import com.noodle.pojo.po.ArticleTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleTypeMapper {
    int countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}