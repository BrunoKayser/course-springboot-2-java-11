package com.educandoWeb.course.services;


import com.educandoWeb.course.entities.Product;
import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.repositories.ProductRepository;
import com.educandoWeb.course.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}
