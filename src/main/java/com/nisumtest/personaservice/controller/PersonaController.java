package com.nisumtest.personaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisumtest.personaservice.domain.Persona;
import com.nisumtest.personaservice.exceptions.NotFoundException;
import com.nisumtest.personaservice.service.PersonaService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(value ="/persona")
public class PersonaController {

	
	
	@Autowired
	private PersonaService service;
	
	@GetMapping("/{id}")
	public Mono<Persona> getPersona(@PathVariable("id") Integer id){
		
		return service.getById(id).switchIfEmpty(Mono.error(new NotFoundException()));
	}
	
	@GetMapping("/")
	public Flux<Persona> getAllPersona(){
		
		return service.getList();
	}
	
	@PostMapping
	public Mono<Persona> create(@Validated @RequestBody Persona personaReq){
		log.info("Creating new persona {}", personaReq);
		return service.createPersona(personaReq);
	}
	
	@PatchMapping
	public Mono<Persona> update( @Validated @RequestBody Persona personaReq){
		log.info("Updating new persona {}", personaReq);
		return service.update(personaReq);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Integer> delete(@PathVariable("id") Integer id){
		log.info("Updating new persona {}", id);
		return service.remove(id);
	}
}
