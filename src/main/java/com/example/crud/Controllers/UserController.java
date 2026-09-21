package com.example.crud.Controllers;

import com.example.crud.Entities.UserEntity;
import com.example.crud.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class UserController {
    private final UserService userservice;

    public UserController(UserService userservice){
        this.userservice = userservice;
    }

    @GetMapping("/listaralunos")
    public ResponseEntity<List<UserEntity>> list(){
        List<UserEntity> usuario = userservice.findAll();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable Long id){
        Optional<UserEntity> usuario = userservice.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario.get());
    }

    @PostMapping("/criar")
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity user){
        UserEntity usuario = userservice.save(user);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        userservice.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
