package com.sdk.service;

import com.sdk.controller.CategoryController;
import com.sdk.dto.CategoryDto;
import com.sdk.dto.CategoryResponse;
import com.sdk.entity.Category;

import java.util.List;

public interface CategoryService {
    public Boolean saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getAllCategory();

    List<CategoryResponse> getActiveCategory();
}
