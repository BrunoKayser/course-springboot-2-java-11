package com.educandoWeb.course.resources;

import com.educandoWeb.course.entities.Category;
import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.services.CategoryService;
import com.educandoWeb.course.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controlador Rest
@RequestMapping(value = "/categories") // Para colocar o caminho do Path, ou nome do recurso
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
