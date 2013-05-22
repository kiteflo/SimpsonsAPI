package com.kiteflo.simpsons.util;

import java.text.Normalizer;
import java.text.Normalizer.Form;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

/**
 * Provide some common methods which can be used to make live easier using
 * Strings...
 */
public class StringTools
{
	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------
	
	private static String[] searchList = { "Ä", "ä", "Ö", "ö", "Ü", "ü", "ß","ç","É","é","À","à","È","è","ì","Ì","ê","Ê" };
	private static String[] replaceList = { "Ae", "ae", "Oe", "oe", "Ue", "ue","ss","c","E","e","A","a","E","e","i","I","e","E" };
	// ------------------------------------------------------------------------
	// public static usage
	// ------------------------------------------------------------------------

	/**
	 * Remove duplicate words from String...
	 * @param str
	 * @return
	 */
	public static String removeDuplicateWords(String str) 
	{
		String[] s = str.split(" ");
		StringBuffer noDupes = new StringBuffer();
		for (int i = 0; i < s.length; i++) 
		{
			if (noDupes.toString().indexOf(s[i]) < 0) 
			{
				// -1 otherwise, if not in noDupes
				noDupes.append(s[i]);
				noDupes.append(" ");
			}
			// keep duplicate "+" signs for AND search... 
			else if (s[i] != null && s[i].equals("+"))
			{
				// -1 otherwise, if not in noDupes
				noDupes.append(s[i]);
				noDupes.append(" ");
			}
		}
		
		return noDupes.toString();
	}
	
	/**
	 * Check whether string1 contains any word which is contained in 
	 * string2 - if so, we will remove it...
	 * Result will be a cleared version of string1 without any string2
	 * elements...
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String removeDuplicateWords(String str1,String str2) 
	{
		String[] s1 = str1.split(" ");
		String[] s2 = str2.split(" ");
		
		StringBuffer noDupes = new StringBuffer();
		for (int i=0; i<s1.length; i++)
		{
			boolean add = true;
			for (int j=0; j<s2.length; j++)
			{
				// duplicate
				if (s2[j].equalsIgnoreCase(s1[i]))
				{
					add = false;
				}
			}
			if (add)
			{
				noDupes.append(s1[i]);
				noDupes.append(" ");
			}
		}
		
		return noDupes.toString();
	}
	
	/**
	 * Tidy up string in order to be able to execute searches on
	 * "Kart, Racing" the same way we treat "Kart Racing". We will cut off
	 * most of the special characters, this method will be kept "alive"
	 * so any time we hit a search string resulting in strange search results
	 * we can add a certaiun rule right here...
	 * @param searchString
	 * @return
	 */
	public static String replaceSpecialCharacters(String searchString)
	{
		// replace ","
		searchString = searchString.replaceAll(","," ");
		
		// replace "."
		searchString = searchString.replaceAll("\\.", " ");
		
		// replace ;
		searchString = searchString.replaceAll(";"," ");
		
		// replace -
		searchString = searchString.replaceAll("-"," ");
		
		// replace "   "
		searchString = searchString.replaceAll("   "," ");
		
		// replace "  "
		searchString = searchString.replaceAll("  "," ");
		
		// maybe add some more blank-replacements some time...
		
		return searchString;
	}
	
//	/**
//	 * Replace speacial characters for vanity urls
//	 */
//	public static String replaceSpecialCharactersForVanityUrl(String searchString) {
//		// replace ","
//		searchString = searchString.replaceAll(","," ");
//		// replace "-"
//		searchString = searchString.replaceAll("-","");
//		// replace "-"
//		searchString = searchString.replaceAll("&"," ");
//		
//		// replace "."
//		searchString = searchString.replaceAll("\\.", " ");
//		
//		// replace ;
//		searchString = searchString.replaceAll(";"," ");
//		
//		// replace "
//		searchString = searchString.replaceAll("\"", "");
//		
//		// replace '
//		searchString = searchString.replaceAll("'","");
//		
//		// replace `
//		searchString = searchString.replaceAll("`","");
//		
//		return searchString;
//	}
	
	/**
//	 * Replace speacial characters for vanity urls
//	 */
	public static String replaceAllNonAplhaNonDigitNonWhitespace(String searchString) {

		searchString = searchString.replaceAll("[^a-zA-Z0-9\\s]+","");
	
		return searchString;
	}
	
	/**
	 * Convert city string from ip2Location DB to nice, readable
	 * city name...ip2loc will return sth like this: LIESTAL
	 * @param city
	 * @return
	 */
	public static String beautifyCityName(String city)
	{
		city = WordUtils.capitalizeFully(city);
        return city;
	}

    /**
     * Normalizes a String by removing all accents to original 127 US-ASCII
     * characters. This method handles German umlauts and "sharp-s" correctly
     * 
     * @param s
     *            The String to normalize
     * @return The normalized String
     */
    public static String normalize(String s) {
        if (s == null)
            return null;

        String n = null;

        n = StringUtils.replaceEachRepeatedly(s, searchList, replaceList);
        n = Normalizer.normalize(n, Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        return n;
    }

    /**
     * Returns a clean representation of a String which might be used safely
     * within an URL. Slugs are a more human friendly form of URL encoding a
     * String.
     * <p>
     * The method first normalizes a String, then converts it to lowercase and
     * removes ASCII characters, which might be problematic in URLs:
     * <ul>
     * <li>all whitespaces
     * <li>dots ('.')
     * <li>slashes ('/')
     * </ul>
     * 
     * @param s
     *            The String to slugify
     * @return The slugified String
     * @see #normalize(String)
     */
    public static String slugify(String s) {

        if (s == null)
            return null;

        String n = normalize(s);
        n = StringUtils.lowerCase(n);
        n = n.replaceAll("[\\s./]", "");

        return n;
    }
    
    /**
     * Replace last occurance of string...
     * @param string
     * @param toReplace
     * @param replacement
     * @return
     */
    public static String replaceLast(String string, String toReplace, String replacement) 
    {
        int pos = string.lastIndexOf(toReplace);
        if (pos > -1) 
        {
            return string.substring(0, pos)
                 + replacement
                 + string.substring(pos + toReplace.length(), string.length());
        } 
        else 
        {
            return string;
        }
    }
    
	// ------------------------------------------------------------------------
	// private usage
	// ------------------------------------------------------------------------

	// ------------------------------------------------------------------------
	// GETTER & SETTER
	// ------------------------------------------------------------------------
}
