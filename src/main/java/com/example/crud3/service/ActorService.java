package com.example.crud3.service;

import com.example.crud3.entity.Actor;
import com.example.crud3.repository.ActorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor findActorById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with id = " + id));
    }

    public List<Actor> findActorByFirstName(String firstName) {
        List<Actor> actorList = actorRepository.findActorsByFirstName(firstName);
        if (firstName == null) {
            throw new EntityNotFoundException("Actors not found with name = " + firstName);
        }
        return actorList;
    }

    public List<Actor> findActorByLastName(String lastName) {
        List<Actor> actorList = actorRepository.findActorsByLastName(lastName);
        if (lastName == null) {
            throw new EntityNotFoundException("Actors not found with name = " + lastName);
        }
        return actorList;
    }

    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    public Actor updateActor(Long id, Actor actor) {
        return actorRepository.findById(id).map(entity -> {
            entity.setFirstName(actor.getFirstName());
            entity.setLastName(actor.getLastName());
            entity.setAge(actor.getAge());
            entity.setMovies(actor.getMovies());
            return actorRepository.save(entity);
        }).orElseThrow(() -> new EntityNotFoundException("Actor not found with id = " + id));
    }

    public void deleteActorById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with id = " + id));
        actorRepository.delete(actor);
    }

    public void deleteActorsByAge(Integer age) {
        actorRepository.deleteActorsByAge(age);
    }

    public void deleteAllActors() {
        actorRepository.deleteAll();
    }
}
