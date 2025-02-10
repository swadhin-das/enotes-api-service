package com.sdk.service.impl;

import com.sdk.controller.CategoryController;
import com.sdk.entity.Category;
import com.sdk.repository.CategoryRepository;
import com.sdk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Boolean saveCategory(Category category) {
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
    public List<Category> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        System.out.println("Hey ");
        return categories;

    }
}
