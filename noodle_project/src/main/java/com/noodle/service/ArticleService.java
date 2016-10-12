package com.noodle.service;

import java.util.List;

import com.noodle.pojo.po.Article;
import com.noodle.process.result.ExceptionResultInfo;

public interface ArticleService {
	
	public List<Article> getTopArticle() throws ExceptionResultInfo;
	public List<Article> getAllArticle() throws ExceptionResultInfo;
	public int addArticle(Article article)throws ExceptionResultInfo;
}
