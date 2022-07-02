package com.tang.blog.service;

import com.tang.blog.vo.CategoryVo;
import com.tang.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
