package com.br.github.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.github.model.Event;
import com.br.github.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event createEvent(Event event) {
		validIfEndTimeIsGreaterThanStartTime(event.endTime, event.startTime);
		validIfExistsDuplicatedEventByDateAndName(event);
		Event eventCreated = eventRepository.save(event);
		return eventCreated;
	}

	private void validIfEndTimeIsGreaterThanStartTime(LocalDateTime endTime, LocalDateTime startTime) {
		if (endTime.isBefore(startTime))
			throw new RuntimeException("The end time can't be less than start time");
	}

	private void validIfExistsDuplicatedEventByDateAndName(Event event) {
		Optional<Event> duplicatedEvent = eventRepository.findByNameAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
				event.name, event.startTime, event.endTime);
		if (!duplicatedEvent.isEmpty()) {
			throw new RuntimeException("Event with the same name and time already exists");
		}
	}
}
