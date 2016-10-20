package com.noodle.Article.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noodle.pojo.po.Article;
import com.noodle.pojo.po.ArticleType;
import com.noodle.process.result.ExceptionResultInfo;
import com.noodle.process.result.ResultInfo;
import com.noodle.service.ArticleService;
import com.noodle.service.ArticleTypeService;

@Controller
@RequestMapping("/article")
public class ArticleAction {
	@Autowired
	private ArticleService articleService;
	@Autowired
	ArticleTypeService articleTypeService;

	@RequestMapping("/getArticleType")
	public String getArticleType(Model model) throws ExceptionResultInfo {
		List<ArticleType> articleTypes = null;
		List<Article> articles = null;
		try {
			articleTypes = articleTypeService.getAllArticleType();
			articles = articleService.getAllArticle();
		} catch (ExceptionResultInfo e) {
			throw new ExceptionResultInfo(new ResultInfo(ResultInfo.TYPE_RESULT_FAIL, 00002, "查询文章分类错误!"));
		}
		model.addAttribute("articleTypes", articleTypes);
		model.addAttribute("articles", articles);
		return "/base/my/addArticle";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(Article article, HttpServletRequest request, HttpServletResponse response)
			throws ExceptionResultInfo {
		try {
			article.setArticleStatus("0");
			article.setArticleSubstr(article.getArticleContent().substring(0, 100));
			articleService.addArticle(article);
		} catch (ExceptionResultInfo e) {
			throw new ExceptionResultInfo(new ResultInfo(ResultInfo.TYPE_RESULT_FAIL, 00002, "添加文章失败!"));
		}
		return "redirect:/first.action";
	}
}
