package com.nisumtest.personaservice.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nisumtest.personaservice.domain.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class PersonaDao {
	
	
    private static final Logger log= LoggerFactory.getLogger(PersonaDao.class);

	private Map<Integer,Persona> objs = new HashMap<>();
	
	@PostConstruct
	public void init() {
		
		log.debug("Creating in-memory personas list");
	}
	
	
	public Mono<Persona> findById(Integer val){
		return Mono.justOrEmpty(objs.get(val)); 
	}
	
	public Mono<Persona> save(Persona val){
		objs.put(val.getId(), val);
		return Mono.just(val);
	}


	public Flux<Persona> findAll() {
		// TODO Auto-generated method stub
		return Flux.fromIterable(objs.values());
	}
	
	
	public Mono<Integer> remove(Integer id) {
		 objs.remove(id);
		 return Mono.just(id);
	}
	
	
	
	
	

}
