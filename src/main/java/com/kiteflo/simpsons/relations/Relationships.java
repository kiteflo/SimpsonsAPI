package com.kiteflo.simpsons.relations;

/**
 * This class is used to store all relationships used in the Springfield graph.
 * Accessing relationships via common members is much better than wiring these
 * as Strings into Cypher...
 */
public class Relationships
{
	// family related
	public static final String IS_FATHER_OF = "IS_FATHER_OF";
	public static final String IS_MARRIED_WITH = "IS_MARRIED_WITH";
	public static final String IS_BROTHER_OF = "IS_BROTHER_OF";
	public static final String IS_SISTER_OF = "IS_SISTER_OF";
	public static final String IS_FRIEND_OF = "IS_FRIEND_OF";
	public static final String IS_ENEMY_OF = "IS_ENEMY_OF";
	public static final String IS_FAN_OF = "IS_FAN_OF";
	public static final String PAST_LOVES = "PAST_LOVES";	
	
	// others
	public static final String HAS_HOBBY = "HAS_HOBBY";
	public static final String LIKES_FOOD = "LIKES_FOOD";
	public static final String LIKES_DRINK = "LIKES_DRINK";
	public static final String IS_AFRAID_OF = "IS_AFRAID_OF";
}
