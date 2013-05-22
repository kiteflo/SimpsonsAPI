package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiteflo.simpsons.domain.Hobby;

/**
 * Graph access layer to Hobbies...
 */
@Repository
public interface HobbyRepository extends GraphRepository<Hobby>
{
	/**
	 * Find all hobbies...
	 * @param page
	 * @return
	 */
	@Query("start hobbies=node:__types__(className='com.kiteflo.simpsons.domain.Hobby') " +
		   "return hobbies")
	public Page<Hobby> findAllHobbies(Pageable page);
	
	/**
	 * Find all hobbies matching given searchTerm by applying a foggy LIKE
	 * search.
	 * @param searchString
	 * @param page
	 * @return
	 */
	@Query("start hobbies=node:INDEX_HOBBY({searchString}) " +
			"return distinct hobbies")
	public Page<Hobby> findHobbiesLike(@Param("searchString") String searchString,
			Pageable page);
}
