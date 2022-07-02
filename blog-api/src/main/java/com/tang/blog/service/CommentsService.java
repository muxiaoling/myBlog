package com.tang.blog.service;

import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.CommentParam;

public interface CommentsService {

    /**
     * 根据文章id查询所有评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
