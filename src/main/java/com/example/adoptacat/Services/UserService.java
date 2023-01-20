package com.example.adoptacat.Services;

import com.example.adoptacat.Entities.User;
import com.example.adoptacat.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void addUser(User user){
        userRepository.save(user);
    }
    public User checkLogin(User user){
        User oldUser=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        return oldUser;
    }
}
