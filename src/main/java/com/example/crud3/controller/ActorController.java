package com.example.crud3.controller;

import com.example.crud3.entity.Actor;
import com.example.crud3.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/actors")
    @ResponseStatus(HttpStatus.CREATED)
    public Actor saveActor(@RequestBody Actor actor){
        return actorService.saveActor(actor);
    }

    @GetMapping("/actors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Actor findActorById(@PathVariable Long id){
        return actorService.findActorById(id);
    }

    @GetMapping("/actors/firstname/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> findActorByFirstName(@PathVariable String firstName){
        return actorService.findActorByFirstName(firstName);
    }

    @GetMapping("/actors/lastname/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> findActorByLastName(@PathVariable String lastName){
        return actorService.findActorByLastName(lastName);
    }

    @GetMapping("/actors")
    @ResponseStatus(HttpStatus.OK)
    public List<Actor> findAllActors(){
        return actorService.findAllActors();
    }

    @PutMapping("/actors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor){
        return actorService.updateActor(id, actor);
    }

    @DeleteMapping("/actors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActorById(@PathVariable Long id){
        actorService.deleteActorById(id);
    }

    @DeleteMapping("/actors/age/{age}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActorsByAge(@PathVariable Integer age){
        actorService.deleteActorsByAge(age);
    }
    @DeleteMapping("/actors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllActors(){
        actorService.deleteAllActors();
    }
}
