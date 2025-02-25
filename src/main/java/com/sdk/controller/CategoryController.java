package com.sdk.controller;

import com.sdk.dto.CategoryDto;
import com.sdk.dto.CategoryResponse;
import com.sdk.entity.Category;
import com.sdk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired  //@Autowired Automatically creates object and add dependency injection
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){// ? mean we can return any value
        Boolean saveCategory = categoryService.saveCategory(categoryDto);
        if (saveCategory){
            return new ResponseEntity<>("saved success",HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory(){
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        if (CollectionUtils.isEmpty(allCategory)){
            return ResponseEntity.noContent().build();
        }else {
            return new ResponseEntity<>(allCategory,HttpStatus.OK);
        }
    }

    @GetMapping("/active-category")
    public ResponseEntity<?> getActiveCategory(){
        List<CategoryResponse> allCategory = categoryService.getActiveCategory();
        if (CollectionUtils.isEmpty(allCategory)){
            return ResponseEntity.noContent().build();
        }else {
            return new ResponseEntity<>(allCategory,HttpStatus.OK);
        }
    }
}
