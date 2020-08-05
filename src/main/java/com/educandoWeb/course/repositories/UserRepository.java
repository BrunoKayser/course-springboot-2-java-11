package com.educandoWeb.course.repositories;

import com.educandoWeb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
