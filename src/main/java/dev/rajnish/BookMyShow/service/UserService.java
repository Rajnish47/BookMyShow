package dev.rajnish.BookMyShow.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.exception.InvalidUserDetailsException;
import dev.rajnish.BookMyShow.model.User;
import dev.rajnish.BookMyShow.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(String name,String email,String password)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);        
    }

    public User userLogin(String email,String password)
    {
        User user = getUser(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!user.getEmail().equals(email))
        {
            throw new InvalidUserDetailsException("Wrong Email");
        }

        if(bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            return user;
        }

        throw new InvalidUserDetailsException("Invalid Password");
    }

    public User getUser(int id)
    {
        return userRepository.findById(id).get();
    }

    public User getUser(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);        
    }

    public void deleteUser(String email)
    {
        User user = userRepository.findUserByEmail(email);
        userRepository.deleteById(user.getId());
    }    
}
