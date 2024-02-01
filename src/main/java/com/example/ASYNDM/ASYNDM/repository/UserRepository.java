package com.example.ASYNDM.ASYNDM.repository;

import com.example.ASYNDM.ASYNDM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public boolean existsByEmail(String email);
    public User findByEmail(String email);

}