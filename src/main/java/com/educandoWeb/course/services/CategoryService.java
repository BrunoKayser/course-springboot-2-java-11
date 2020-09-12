package com.educandoWeb.course.services;


import com.educandoWeb.course.entities.Category;
import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.repositories.CategoryRepository;
import com.educandoWeb.course.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
