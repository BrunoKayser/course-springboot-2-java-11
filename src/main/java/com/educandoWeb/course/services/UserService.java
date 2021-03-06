package com.educandoWeb.course.services;


import com.educandoWeb.course.entities.User;
import com.educandoWeb.course.repositories.UserRepository;
import com.educandoWeb.course.services.exceptions.DataBaseException;
import com.educandoWeb.course.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        // Get one é mais eficiente que o findById para fazer alterações
        // Enquando o findById pega direto do banco de dados o objeto, o getOne não
        // prepara o objeto monitorado para eu poder mecher e depois efetuar uma operação com o banco de dados
        try {
            User entity = userRepository.getOne(id);
            updateData(entity, user);
            return userRepository.save(entity);

        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
