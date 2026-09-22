package com.example.crud.Services;

import com.example.crud.DTO.UserResponseDTO;
import com.example.crud.Entities.UserEntity;
import com.example.crud.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    private UserResponseDTO toDTO(UserEntity user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO save(UserEntity user){
        return toDTO(userRepository.save(user));
    }

    public List<UserResponseDTO> findAll(){
        return userRepository.findAll().stream().map(this::toDTO).toList();
    }

    public List<UserResponseDTO> findAllOrderByPassword(){
        return userRepository.FindAllOrderByPassword().stream().map(this::toDTO).toList();
    }

    public Optional<UserResponseDTO> findById(UUID id){
        return userRepository.findById(id).map(this::toDTO);
    }

    public void deleteByID(UUID id){
        userRepository.deleteById(id);
    }

}
