package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.kiteflo.simpsons.domain.VoiceActor;

/**
 * Graph access layer to Springfield...
 */

public interface VoiceActorRepository extends GraphRepository<VoiceActor>
{
	@Query("start actors=node:__types__(className='VoiceActor') " +
		   "return actors")
	public Page<VoiceActor> findAllVoiceActors(Pageable page);
}
