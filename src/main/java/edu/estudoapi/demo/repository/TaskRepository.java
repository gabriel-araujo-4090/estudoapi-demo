package edu.estudoapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.estudoapi.demo.entity.Task;

@Repository 
public interface TaskRepository
        extends JpaRepository<Task, Long> {
}