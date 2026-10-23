package edu.estudoapi.demo.service;

import org.springframework.stereotype.Service;

import edu.estudoapi.demo.entity.User;
import edu.estudoapi.demo.repository.UserRepository;

@Service 
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User buscarPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    
}
