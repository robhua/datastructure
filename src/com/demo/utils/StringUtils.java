package com.demo.utils;

import java.util.Arrays;
import java.util.List;

public final class StringUtils {
	private StringUtils() {
		
	}
	/*
	 * delimiter defined as: zero or more whitespace, a literal comma, zero or more whitespace
	 */
	private static final String delimiter = "\\s*,\\s*";
	/*
	 * English articles
	 */
	private static final String[] articles = {"a", "an", "the"};
	private static int maxArticleLen = 0;
	
    // The most commonly used English words.
    private static String commonWords[] =
    {
        "a", "an", "and", "are", "at",
        "be", "by",
        "for", "from",
        "have",
        //"he", "his",
        //"i",
        "in", "is", "it",
        "of", "on", "or",
        "that", "this", "the",
        //"they",
        "to",
        "was", "with"
        //"you"
    };
    private static int maxCommonWordLen = 0;
    
    static
    {
        Arrays.sort(commonWords);

        for (String article : articles)
        {
            int articleLen = article.length();
            if (maxArticleLen < articleLen)
                maxArticleLen = articleLen;
        }
        
        for (String commonWord : commonWords)
        {
            int commonWordLen = commonWord.length();
            if (maxCommonWordLen < commonWordLen)
                maxCommonWordLen = commonWordLen;
        }
    }
    
	public static boolean isArticle(String str) {
		if (str == null)
			return false;
		if (str.length() > maxArticleLen)
			return false;
		str = str.toLowerCase();
		
		if (articles[0].equals(str))
			return true;
		else if (articles[1].equals(str))
			return true;
		else if (articles[2].equals(str))
			return true;
		
		return false;
	}
	
    public static boolean isCommonWord(String str)
    {
        if (str == null)
            return false;
        if (str.length() > maxCommonWordLen)
            return false;
        str = str.toLowerCase();
        if (Arrays.binarySearch(commonWords, str) >= 0)
            return true;
        return false;
    }	
    
	public static boolean isNotBlank(String str) {
		if (str != null && !str.isEmpty())
			return true;

		return false;
	}
	
	public static boolean isBlank(String str) {
		if (str == null || str.isEmpty())
			return true;

		return false;
	}
	
	public static int length(String str) {
		if (str == null)
			return 0;

		return str.length();
	}
	
	public static boolean isTrue(String str) {
		if (str == null) {
			return false;
		}
		return "Y".equalsIgnoreCase(str) || 
				"YES".equalsIgnoreCase(str)	|| 
				"T".equalsIgnoreCase(str) || 
				"TRUE".equalsIgnoreCase(str);
	}

	public static boolean isFalse(String str) {
		if (str == null) {
			return false;
		}
		return "N".equalsIgnoreCase(str) || 
				"NO".equalsIgnoreCase(str) || 
				"F".equalsIgnoreCase(str) || 
				"FALSE".equalsIgnoreCase(str);
	}

	public static boolean stringsAreEqual(String str1, String str2) {
		if (str1 == str2) {
			return true; // includes str1 == null && str2 == null
		}

		if (str1 != null) {
			return str1.equals(str2);
		}

		return false; // str1 == null, str2 != null
	}
	
	public static boolean isTrue(Boolean booleanObj) {
		return booleanObj != null && booleanObj.booleanValue();
	}

	public static boolean isFalse(Boolean booleanObj) {
		return booleanObj != null && !booleanObj.booleanValue();
	}
	
	/*
	 *  Convert comma separated String to ArrayList using delimiter default
	 */
	public static List<String> convertStringToList(String str) {
		return convertStringToList(str, delimiter);
	}
	
	public static List<String> convertStringToList(String str, String delimiter) {
		List<String> items = Arrays.asList(str.split(delimiter));
		return items;
	}
}
