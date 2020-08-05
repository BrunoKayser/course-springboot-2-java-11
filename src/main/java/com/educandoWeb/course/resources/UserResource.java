package com.educandoWeb.course.resources;

import com.educandoWeb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controlador Rest
@RequestMapping(value = "/users") // Para colocar o caminho do Path, ou nome do recurso
public class UserResource {

    @GetMapping
    public ResponseEntity <User> findAll(){
        User u = new User(1L, "Bruno", "bruno@Gmail.com", "9999999","1234567");
        return ResponseEntity.ok().body(u);
    }
}
