package com.noodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.dao.mapper.ArticleTypeMapper;
import com.noodle.pojo.po.ArticleType;
import com.noodle.pojo.po.ArticleTypeExample;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.service.ArticleTypeService;

public class ArticleTypeServiceImpl implements ArticleTypeService {
	
	@Autowired private ArticleTypeMapper articleTypeMapper;
	@Override
	public List<ArticleType> getAllArticleType() throws ExceptionResultInfo {
		ArticleTypeExample articleTypeExample=new ArticleTypeExample();
		ArticleTypeExample.Criteria criteria=articleTypeExample.createCriteria();
		return articleTypeMapper.selectByExample(articleTypeExample);
	}
}
