package com.kiteflo.simpsons.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiteflo.simpsons.domain.FavDrink;
import com.kiteflo.simpsons.domain.FavFood;
import com.kiteflo.simpsons.domain.Hobby;

/**
 * Graph access layer to favorite drinks...
 */
@Repository
public interface FavDrinkRepository extends GraphRepository<FavDrink>
{
	/**
	 * Find all favorite drinks...
	 * @param page
	 * @return
	 */
	@Query("start favdrink=node:__types__(className='com.kiteflo.simpsons.domain.FavDrink') " +
		   "return favdrink")
	public Page<FavDrink> findAllFavDrinks(Pageable page);
	
	/**
	 * Find all favorite drinks matching given searchTerm by applying a foggy LIKE
	 * search.
	 * @param searchString
	 * @param page
	 * @return
	 */
	@Query("start favdrink=node:INDEX_FAVDRINK({searchString}) " +
			"return distinct favdrink")
	public Page<FavDrink> findFavDrinksLike(@Param("searchString") String searchString,
			Pageable page);
}
