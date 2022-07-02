package com.tang.blog.dao.mapper;

import com.tang.blog.dao.pojo.Tag;
import com.tang.blog.service.CommentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagMapperTest {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private CommentsService commentsService;


    @Test
    public void tagList() {
        Long a = 1L;
        List<Tag> list= tagMapper.findTagsByArticleId(a);
        for (Tag tag : list) {
            System.out.println(tag.toString());
        }
    }

    @Test
    public void testCommentCount() {

    }

}