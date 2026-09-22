package com.example.crud.Controllers;

import com.example.crud.DTO.UserResponseDTO;
import com.example.crud.Entities.UserEntity;
import com.example.crud.Repositories.UserRepository;
import com.example.crud.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userservice;

    public UserController(UserService userservice){
        this.userservice = userservice;
    }

    @GetMapping("/listarusers")
    public ResponseEntity<List<UserResponseDTO>> list(){
        List<UserResponseDTO> usuario = userservice.findAll();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/ordernados/senhas")
    public ResponseEntity<List<UserResponseDTO>> BuscarOrdenadosPorSenha(@RequestParam String senha){
        List<UserResponseDTO> usuario = userservice.findAllOrderByPassword();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> buscarPorID(@PathVariable UUID id){
        Optional<UserResponseDTO> usuario = userservice.findById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criar")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserEntity user){
        UserResponseDTO usuario = userservice.save(user);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        userservice.deleteByID(id);
        return ResponseEntity.noContent().build();
    }


}
