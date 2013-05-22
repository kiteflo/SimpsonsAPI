package com.kiteflo.simpsons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kiteflo.simpsons.domain.Fear;
import com.kiteflo.simpsons.repositories.FearRepository;
import com.kiteflo.simpsons.util.NeoSearchTermUtil;

/**
 * Some hobby related services...
 */
@Service
public class FearService
{
	@Autowired
	private FearRepository fearRepository;
	
	/**
	 * Find fears using foggy "LIKE" query...
	 * @param searchString
	 * @param page
	 * @return
	 */
	public Page<Fear> findFearsLike(String searchString, Pageable page)
	{
		String query = NeoSearchTermUtil.setupKeywordSearchQuery(searchString,"name");
		return fearRepository.findFearsLike(query, page); 
	}
}
