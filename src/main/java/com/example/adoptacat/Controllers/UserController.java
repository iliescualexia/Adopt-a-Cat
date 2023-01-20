package com.example.adoptacat.Controllers;

import com.example.adoptacat.Entities.User;
import com.example.adoptacat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/api/v1/register",method = RequestMethod.POST)
    public ResponseEntity<User> Register(@RequestBody User user){
        try{
            userService.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/api/v1/login",method = RequestMethod.POST)
    public ResponseEntity<User> Login(@RequestBody User user){
        try{
            if(userService.checkLogin(user)!=null) {
                return new ResponseEntity<>(userService.checkLogin(user), HttpStatus.OK);
            }
            return new ResponseEntity<>(userService.checkLogin(user),HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
