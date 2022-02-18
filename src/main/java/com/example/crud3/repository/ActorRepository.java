package com.example.crud3.repository;

import com.example.crud3.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Transactional(readOnly = true)
    @Query("select a from Actor a where a.firstName like :firstName")
    List<Actor> findActorsByFirstName(String firstName);

    @Transactional(readOnly = true)
    @Query("select a from Actor a where a.lastName like :lastName")
    List<Actor> findActorsByLastName(String lastName);

    @Modifying
    @Transactional(readOnly = true)
    @Query("select a from Actor a where a.age = :age")
    int deleteActorsByAge(Integer age);
}
