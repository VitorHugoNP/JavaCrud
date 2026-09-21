package com.example.crud.Services;

import com.example.crud.Entities.UserEntity;
import com.example.crud.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public void deleteByID(Long id){
        userRepository.deleteById(id);
    }

}
