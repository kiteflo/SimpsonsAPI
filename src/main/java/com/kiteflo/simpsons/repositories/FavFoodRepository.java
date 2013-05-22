package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiteflo.simpsons.domain.FavFood;
import com.kiteflo.simpsons.domain.Hobby;

/**
 * Graph access layer to Hobbies...
 */
@Repository
public interface FavFoodRepository extends GraphRepository<FavFood>
{
	/**
	 * Find all favorite foods...
	 * @param page
	 * @return
	 */
	@Query("start favfood=node:__types__(className='com.kiteflo.simpsons.domain.FavFood') " +
		   "return favfood")
	public Page<FavFood> findAllFavFoods(Pageable page);
	
	/**
	 * Find all favorite foods matching given searchTerm by applying a foggy LIKE
	 * search.
	 * @param searchString
	 * @param page
	 * @return
	 */
	@Query("start favfood=node:INDEX_FAVFOOD({searchString}) " +
			"return distinct favfood")
	public Page<FavFood> findFavFoodsLike(@Param("searchString") String searchString,
			Pageable page);
}
