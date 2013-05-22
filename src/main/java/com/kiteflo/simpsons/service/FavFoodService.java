package com.kiteflo.simpsons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kiteflo.simpsons.domain.FavFood;
import com.kiteflo.simpsons.repositories.FavFoodRepository;
import com.kiteflo.simpsons.util.NeoSearchTermUtil;

/**
 * Some favorite food related services...
 */
@Service
public class FavFoodService
{
	@Autowired
	private FavFoodRepository favFoodRepository;
	
	/**
	 * Findfavorite foods using foggy "LIKE" query...
	 * @param searchString
	 * @param page
	 * @return
	 */
	public Page<FavFood> findFavFoodsLike(String searchString, Pageable page)
	{
		String query = NeoSearchTermUtil.setupKeywordSearchQuery(searchString,"name");
		return favFoodRepository.findFavFoodsLike(query, page); 
	}
}
