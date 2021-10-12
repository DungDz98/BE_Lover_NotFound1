package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<Iterable<Category>> findAll() {
        Iterable<Category> categoryServices = categoryService.findAll();
        return new ResponseEntity<>(categoryServices, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Category> update (@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        category.setId(id);
        if (category.getName().trim().equals("") || (category.getName() == null)) {
            category.setName(categoryOptional.get().getName());
        }

        if (category.getTypeService() == null){
            category.setTypeService(categoryOptional.get().getTypeService());
        }
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategoryById(@PathVariable Long id){
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
