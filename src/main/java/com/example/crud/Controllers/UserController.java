package com.example.crud.Controllers;

import com.example.crud.Entities.UserEntity;
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
    public ResponseEntity<List<UserEntity>> list(){
        List<UserEntity> usuario = userservice.findAll();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/ordernados/senhas")
    public ResponseEntity<List<UserEntity>> BuscarOrdenadosPorSenha(@RequestParam String senha){
        List<UserEntity> usuario = userservice.findAllOrderByPassword();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorID(@PathVariable UUID id){
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
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        userservice.deleteByID(id);
        return ResponseEntity.noContent().build();
    }


}
