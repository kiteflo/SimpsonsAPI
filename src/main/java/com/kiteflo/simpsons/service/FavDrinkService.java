package com.kiteflo.simpsons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kiteflo.simpsons.domain.FavDrink;
import com.kiteflo.simpsons.repositories.FavDrinkRepository;
import com.kiteflo.simpsons.util.NeoSearchTermUtil;

/**
 * Some favorite drink related services...
 */
@Service
public class FavDrinkService
{
	@Autowired
	private FavDrinkRepository favDrinkRepository;
	
	/**
	 * Find favorite drinks using foggy "LIKE" query...
	 * @param searchString
	 * @param page
	 * @return
	 */
	public Page<FavDrink> findFavDrinksLike(String searchString, Pageable page)
	{
		String query = NeoSearchTermUtil.setupKeywordSearchQuery(searchString,"name");
		return favDrinkRepository.findFavDrinksLike(query, page); 
	}
}
