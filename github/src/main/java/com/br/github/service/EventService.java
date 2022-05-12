package com.br.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.github.model.Event;
import com.br.github.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event createEvent(Event event) {
		Event eventCreated = eventRepository.save(event);
		return eventCreated;
	}
}
