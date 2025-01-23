package dev.rajnish.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.BookMyShow.model.Actor;
import dev.rajnish.BookMyShow.repository.ActorRepository;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor addActor(String name)
    {
        Actor actor = new Actor();
        actor.setName(name);
        return actorRepository.save(actor);
    }

    public Actor findActor(int id)
    {
        return actorRepository.findById(id).get();
    }

    public Actor findActor(String name)
    {
        return actorRepository.findActorByName(name);
    }

    public void deleteActor(int id)
    {
        actorRepository.deleteById(id);
    }
    
}
