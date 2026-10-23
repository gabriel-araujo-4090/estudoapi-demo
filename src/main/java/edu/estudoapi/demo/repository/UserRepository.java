package edu.estudoapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.estudoapi.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
