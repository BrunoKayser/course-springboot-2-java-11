package com.educandoWeb.course.repositories;

import com.educandoWeb.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
