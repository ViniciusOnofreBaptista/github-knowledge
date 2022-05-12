package com.br.github.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.github.model.Event;
import com.br.github.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping()
	public ResponseEntity<?> createEvent(@RequestBody @Valid Event event) {
		Event createdEvent = eventService.createEvent(event);
		return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
	}

}
