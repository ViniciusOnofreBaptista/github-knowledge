package com.br.github.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.github.model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{

}
