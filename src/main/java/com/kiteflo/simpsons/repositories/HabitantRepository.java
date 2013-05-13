package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.kiteflo.simpsons.domain.Habitant;

/**
 * Graph access layer to Springfield...
 */

public interface HabitantRepository extends GraphRepository<Habitant>
{
	@Query("start simpsons=node:__types__(className='Habitant') " +
		   "return simpsons")
	public Page<Habitant> findAllSimpsons(Pageable page);
}
