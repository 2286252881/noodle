package com.noodle.service;

import java.util.List;

import com.noodle.pojo.po.ArticleType;
import com.noodle.process.result.ExceptionResultInfo;

public interface ArticleTypeService {
	public List<ArticleType> getAllArticleType()throws ExceptionResultInfo;
}
