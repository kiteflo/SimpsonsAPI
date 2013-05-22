package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiteflo.simpsons.domain.Fear;
import com.kiteflo.simpsons.domain.Hobby;

/**
 * Graph access layer to Hobbies...
 */
@Repository
public interface FearRepository extends GraphRepository<Fear>
{
	/**
	 * Find all fears...
	 * @param page
	 * @return
	 */
	@Query("start fears=node:__types__(className='com.kiteflo.simpsons.domain.Fear') " +
		   "return fears")
	public Page<Fear> findAllFears(Pageable page);
	
	/**
	 * Find all hobbies matching given searchTerm by applying a foggy LIKE
	 * search.
	 * @param searchString
	 * @param page
	 * @return
	 */
	@Query("start fears=node:INDEX_FEAR({searchString}) " +
			"return distinct fears")
	public Page<Fear> findFearsLike(@Param("searchString") String searchString,
			Pageable page);
}
