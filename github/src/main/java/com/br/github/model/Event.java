package com.br.github.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

	@Id
	public String id;
	@NotNull()
	public String name;
	@NotNull
	public LocalDateTime startTime;
	@NotNull
	public LocalDateTime endTime;
	
}
