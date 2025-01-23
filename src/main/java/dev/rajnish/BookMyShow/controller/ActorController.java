package dev.rajnish.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.BookMyShow.dto.ActorRequestDTO;
import dev.rajnish.BookMyShow.service.ActorService;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/actor")
    public ResponseEntity addActor(@RequestBody ActorRequestDTO actorRequestDTO)
    {
        try{
            String actorName = actorRequestDTO.getName();
            if(actorName==null || actorName.isEmpty() || actorName.isBlank())
            {
                throw new Exception("Invalid actor name");
            }

            return ResponseEntity.ok(actorService.addActor(actorName));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/actor/id/{id}")
    public ResponseEntity getActor(@PathVariable("id") int actorId)
    {
        try{
            if(actorId<=0)
            {
                throw new Exception("Invalid id");
            }

            return ResponseEntity.ok(actorService.findActor(actorId));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/actor/name/{name}")
    public ResponseEntity getActor(@PathVariable("name") String actorName)
    {
        try{
            if(actorName==null || actorName.isEmpty() || actorName.isBlank())
            {
                throw new Exception("Invalid name");
            }

            return ResponseEntity.ok(actorService.findActor(actorName));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    @DeleteMapping("/actor/delete/{id}")
    public ResponseEntity deleteActor(@PathVariable("id") int actorId)
    {
        try{
            if(actorId<=0)
            {
                throw new Exception("Invalid id");
            }

            actorService.deleteActor(actorId);
            return ResponseEntity.ok("Actor Deleted");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
