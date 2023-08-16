package com.example.backend.dao;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.status = true")
    public List<User> findAllActiveUsers();


    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User findByUserId(@Param("id") long id);
}
