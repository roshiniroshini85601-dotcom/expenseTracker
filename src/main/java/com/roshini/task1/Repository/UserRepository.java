package com.roshini.task1.Repository;

import com.roshini.task1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String title);  //if i give title it had to retrun user nu it will understand
}