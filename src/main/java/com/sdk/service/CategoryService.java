package com.sdk.service;

import com.sdk.controller.CategoryController;
import com.sdk.entity.Category;

import java.util.List;

public interface CategoryService {
    public Boolean saveCategory(Category category);
    public List<Category> getAllCategory();

}
