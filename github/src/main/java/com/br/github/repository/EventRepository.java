package com.br.github.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.github.model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{

	Optional<Event> findByNameAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(String name, LocalDateTime startTime, LocalDateTime endTime);
	
}
