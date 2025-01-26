package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByEmail(String email);
    
}
