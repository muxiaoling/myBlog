package com.tang.blog.controller;

import com.tang.blog.common.aop.LogAnnotation;
import com.tang.blog.service.ArticleService;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.ArticleParam;
import com.tang.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //首页文章列表
    @PostMapping
    @LogAnnotation(module="文章", operator="获取文章列表")
    public Result listArticles(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    //首页文章列表
    @PostMapping("hot")
    public Result hotArticle() {
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    //最新文章
    @PostMapping("new")
    public Result newArticle() {
        int limit = 5;
        return articleService.newArticle(limit);
    }

    //文章归档
    @PostMapping("listArchives")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }
}
