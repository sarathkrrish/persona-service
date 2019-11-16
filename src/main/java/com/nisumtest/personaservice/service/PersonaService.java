package com.nisumtest.personaservice.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisumtest.personaservice.dao.PersonaDao;
import com.nisumtest.personaservice.domain.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaService {

	@Autowired
	private PersonaDao dao;
	
	public Mono<Persona> createPersona(Persona p) {
		
		return dao.save(p);
	}
	
	public Flux<Persona> getList(){
		return dao.findAll();
	}
	
	public Mono<Persona> getById(Integer id){
		return dao.findById(id);
	}
	
	public Mono<Persona> update(Persona persona){
		Mono<Persona> existing = getById(persona.getId());
		if(existing != null) {
			return dao.save(persona);
		}
		throw new NoSuchElementException("Persona Didn't exists for the Id : " + persona.getId());
	}
	
	public Mono<Integer> remove(Integer id) {
		return dao.remove(id);
	}
}
