package com.tang.blog.service;

import com.tang.blog.vo.ArticleVo;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.ArticleParam;
import com.tang.blog.vo.params.PageParams;


public interface ArticleService {
    //分页查询，文章列表
    Result listArticle(PageParams pageParams);
    //首页最热文章
    Result hotArticle(int limit);
    //最新文章
    Result newArticle(int limit);
    //文章归档
    Result listArchives();
    //查看文章详情
    Result findArticleById(Long articleId);
    //文章的发布
    Result publish(ArticleParam articleParam);
}
