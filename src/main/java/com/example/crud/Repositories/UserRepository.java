package com.example.crud.Repositories;

import com.example.crud.Model.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(value = "SELECT * FROM tb_user ORDER BY password DESC", nativeQuery = true)
    List<UserEntity> FindAllOrderByPassword();
}
