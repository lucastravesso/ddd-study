package com.pattern.ddd.repository;

import com.pattern.ddd.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findAll(Pageable pageable);
}