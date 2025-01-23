package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer>{

    public Actor findActorByName(String name);
    
}
