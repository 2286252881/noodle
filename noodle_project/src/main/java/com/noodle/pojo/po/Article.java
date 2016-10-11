package com.noodle.pojo.po;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String articleName;

    private Date articleTime;

    private Long articleClick;

    private Integer articleTypeId;

    private String articleSubstr;

    private String articleContent;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Long getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Long articleClick) {
        this.articleClick = articleClick;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleSubstr() {
        return articleSubstr;
    }

    public void setArticleSubstr(String articleSubstr) {
        this.articleSubstr = articleSubstr == null ? null : articleSubstr.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}