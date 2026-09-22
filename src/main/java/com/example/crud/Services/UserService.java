package com.example.crud.Services;

import com.example.crud.Model.DTO.UserResponseDTO;
import com.example.crud.Model.Entities.UserEntity;
import com.example.crud.Model.Form.UserRequestForm;
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

    public UserResponseDTO save(UserRequestForm form){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(form.name());
        userEntity.setEmail(form.email());
        userEntity.setPassword(form.password());
        return toDTO(userRepository.save(userEntity));
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
