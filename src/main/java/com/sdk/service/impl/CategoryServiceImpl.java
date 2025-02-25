package com.sdk.service.impl;

import com.sdk.controller.CategoryController;
import com.sdk.dto.CategoryDto;
import com.sdk.dto.CategoryResponse;
import com.sdk.entity.Category;
import com.sdk.repository.CategoryRepository;
import com.sdk.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Boolean saveCategory(CategoryDto categoryDto) {

//        Category category = new Category();
//        category.setName(categoryDto.getName());
//        category.setDescription(categoryDto.getDescription());
//        category.setIsActive(categoryDto.getIsActive());

        Category category = mapper.map(categoryDto, Category.class);
        category.setIsDeleted(false);
        category.setCreatedBy(1);
        category.setCreatedOn(new Date());

        Category saveCategory = categoryRepo.save(category);
        if (ObjectUtils.isEmpty(saveCategory)){
            return false;
        }

        return true;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map((cat) -> mapper.map(cat, CategoryDto.class)).toList();
        return categoryDtoList;

    }

    @Override
    public List<CategoryResponse> getActiveCategory() {
        List<Category> categories = categoryRepo.findByIsActiveTrue();
        List<CategoryResponse> categoryList = categories.stream().map(cat -> mapper.map(cat, CategoryResponse.class)).toList();
        return categoryList;
    }
}
