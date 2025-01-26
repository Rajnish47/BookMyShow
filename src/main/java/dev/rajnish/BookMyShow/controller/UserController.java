package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.UserLoginDTO;
import dev.rajnish.BookMyShow.dto.UserRequestDTO;
import dev.rajnish.BookMyShow.exception.NullValuePassedException;
import dev.rajnish.BookMyShow.model.User;
import dev.rajnish.BookMyShow.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody UserRequestDTO userRequestDTO)
    {
        try{

            String userName = userRequestDTO.getName();
            String email = userRequestDTO.getEmail();
            String password = userRequestDTO.getPassword();

            if(userName==null || userName.isEmpty() || userName.isBlank() || email==null || email.isEmpty() || email.isBlank() || password==null || password.isEmpty() || password.isBlank())
            {
                throw new Exception("Invalid user details");
            }

            return ResponseEntity.ok(userService.addUser(userName, email, password));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/user/login")
    public ResponseEntity login(@RequestBody UserLoginDTO userLoginDTO)
    {
        String email = userLoginDTO.getEmail();
        String password = userLoginDTO.getPassword();
        if(email==null || email.isEmpty() || email.isBlank() || password==null || password.isEmpty() || password.isBlank())
        {
            throw new NullValuePassedException("Email or password is missing!!!");
        }
        
        User user = userService.userLogin(email, password);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id)
    {
        try{
            if(id<=0)
            {
                throw new Exception("Invalid id");
            }

            return ResponseEntity.ok(userService.getUser(id));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
