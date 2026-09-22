package com.example.crud.Repositories;

import com.example.crud.Entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(value = "SELECT * FROM tb_user ORDER BY password ASC", nativeQuery = true)
    List<UserEntity> FindAllOrderByPassword();
}
