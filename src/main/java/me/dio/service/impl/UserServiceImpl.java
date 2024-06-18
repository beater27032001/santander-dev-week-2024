package me.dio.service.impl;

import me.dio.model.User;
import me.dio.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This User ID already exists.");
        }
//        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()) &&
//                userRepository.existsByAccountAgency(userToCreate.getAccount().getAgency())){
//            throw new IllegalArgumentException("This Account already exists");
//        }
        return userRepository.save(userToCreate);
    }
}
