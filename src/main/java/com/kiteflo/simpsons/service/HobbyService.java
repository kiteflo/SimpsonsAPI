package com.kiteflo.simpsons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kiteflo.simpsons.domain.Hobby;
import com.kiteflo.simpsons.repositories.HobbyRepository;
import com.kiteflo.simpsons.util.NeoSearchTermUtil;

/**
 * Some hobby related services...
 */
@Service
public class HobbyService
{
	@Autowired
	private HobbyRepository hobbyRepository;
	
	/**
	 * Find hobbies using foggy "LIKE" query...
	 * @param searchString
	 * @param page
	 * @return
	 */
	public Page<Hobby> findHobbiesLike(String searchString, Pageable page)
	{
		String query = NeoSearchTermUtil.setupKeywordSearchQuery(searchString,"name");
		return hobbyRepository.findHobbiesLike(query, page); 
	}
}
