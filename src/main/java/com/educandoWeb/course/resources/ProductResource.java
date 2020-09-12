package com.educandoWeb.course.resources;

import com.educandoWeb.course.entities.Product;
import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.services.ProductService;
import com.educandoWeb.course.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controlador Rest
@RequestMapping(value = "/products") // Para colocar o caminho do Path, ou nome do recurso
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
