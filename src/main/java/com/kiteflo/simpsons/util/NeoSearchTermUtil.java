package com.kiteflo.simpsons.util;

/**
 * Few little helpers in order to execute neo index searches...
 */
public class NeoSearchTermUtil
{
	public static String setupKeywordSearchQuery(String searchString,String key)
	{
		// prepare searchstring...(cut off special characters...)
		searchString = StringTools.replaceSpecialCharacters(searchString);
		
		// remove duplicate words...
		searchString = StringTools.removeDuplicateWords(searchString);
		
		// translate searchstring into cypher query parameter...
		// => name:*string1* AND name:*string2*...
		StringBuffer query = new StringBuffer();
		query.append(key);
		query.append(":*");
		cutStringIntoPiecesForPropertySearch(searchString, query, key);
		
		return query.toString();
	}
	
	private static void cutStringIntoPiecesForPropertySearch(String searchString,StringBuffer query,
			String property)
	{
		if(query.length() == 0){
			//init String
			query.append(property);
			query.append(":*");
		}
		// check whether searchString contains any whitespaces...
		if (searchString.contains(" "))
		{
			String ss = searchString.substring(0,searchString.indexOf(" "));
			//TODO is this the way to handle apostrophs in lucene?
			ss = ss.replace("'", "\\'");
			ss = ss.replace("!", "");
			ss = ss.replace("?", "");
			query.append(ss);
			query.append("*");
			searchString = searchString.substring(searchString.indexOf(" ")+1,
					searchString.length());
			
			if (searchString.length() > 0)
			{
				query.append(" OR ");
				query.append(property);
				query.append(":*");
				cutStringIntoPiecesForPropertySearch(searchString, query, property);
			}
		}
		else
		{
			searchString = searchString.replace("'", "\\'");
			searchString = searchString.replace("!", "");
			searchString = searchString.replace("?", "");
			query.append(searchString);
			query.append("*");
		}
	}
}
