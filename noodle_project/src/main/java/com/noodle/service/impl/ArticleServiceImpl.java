package com.noodle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noodle.dao.mapper.ArticleMapper;
import com.noodle.pojo.po.Article;
import com.noodle.pojo.po.ArticleExample;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> getTopArticle() throws ExceptionResultInfo {
		ArticleExample articleExample = new ArticleExample();
		ArticleExample.Criteria criteria = articleExample.createCriteria();
		criteria.andArticleStatusEqualTo("1");
		return articleMapper.selectByExample(articleExample).subList(0, 5);
	}

	@Override
	public int addArticle(Article article) throws ExceptionResultInfo {
		return articleMapper.insert(article);
	}

	@Override
	public List<Article> getAllArticle() throws ExceptionResultInfo {
		ArticleExample articleExample = new ArticleExample();
		ArticleExample.Criteria criteria = articleExample.createCriteria();
		criteria.andArticleStatusEqualTo("1");
		return articleMapper.selectByExample(articleExample);
	}

}
