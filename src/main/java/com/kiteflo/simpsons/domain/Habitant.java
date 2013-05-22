package com.kiteflo.simpsons.domain;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.kiteflo.simpsons.relations.Relationships;

/**
 * Springfield habitant representation...
 */
@NodeEntity
@XmlRootElement
public class Habitant
{
	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------
	
	@GraphId
	private Long id;
	
	private String firstname;
	private String lastname;
	private String imagePath;
	private int age;
	private float weight;
	private String description;
	private String occupation;
	private String catchPhrase;
	private String maidenName;
	private String otherFacts;
	
	// image path
	private String imageURL;
	
	// human relations
	@RelatedTo(type = Relationships.IS_FATHER_OF, direction = Direction.OUTGOING)
	private Set<Habitant> kids = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.IS_BROTHER_OF, direction = Direction.OUTGOING)
	private Set<Habitant> brothers = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.IS_SISTER_OF, direction = Direction.OUTGOING)
	private Set<Habitant> sisters = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.IS_MARRIED_WITH, direction = Direction.OUTGOING)
	private Set<Habitant> marriagePartner = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.IS_FRIEND_OF, direction = Direction.OUTGOING)
	private Set<Habitant> friends = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.IS_ENEMY_OF, direction = Direction.OUTGOING)
	private Set<Habitant> enemies = new HashSet<Habitant>();
	
	@RelatedTo(type = Relationships.PAST_LOVES, direction = Direction.OUTGOING)
	private Set<Habitant> pastLoves = new HashSet<Habitant>();
	
	// object relationships
	@RelatedTo(type = Relationships.LIKES_FOOD, direction = Direction.OUTGOING)
	private Set<FavFood> favFoods = new HashSet<FavFood>();
	
	@RelatedTo(type = Relationships.LIKES_DRINK, direction = Direction.OUTGOING)
	private Set<FavDrink> favDrinks = new HashSet<FavDrink>();
	
	@RelatedTo(type = Relationships.HAS_HOBBY, direction = Direction.OUTGOING)
	private Set<Hobby> hobbies = new HashSet<Hobby>();
	
	@RelatedTo(type = Relationships.IS_AFRAID_OF, direction = Direction.OUTGOING)
	private Set<Fear> fears = new HashSet<Fear>();
	
	// ------------------------------------------------------------------------
	// overridden stuff
	// ------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return firstname + " " +lastname;
	}
	
	// ------------------------------------------------------------------------
	// GETTER & SETTER
	// ------------------------------------------------------------------------
		
	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getImagePath()
	{
		return imagePath;
	}

	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getImageURL()
	{
		return imageURL;
	}

	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	public String getCatchPhrase()
	{
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase)
	{
		this.catchPhrase = catchPhrase;
	}

	public Set<Habitant> getKids()
	{
		return kids;
	}

	public void setKids(Set<Habitant> kids)
	{
		this.kids = kids;
	}

	public Set<Habitant> getBrothers()
	{
		return brothers;
	}

	public void setBrothers(Set<Habitant> brothers)
	{
		this.brothers = brothers;
	}

	public Set<Habitant> getSisters()
	{
		return sisters;
	}

	public void setSisters(Set<Habitant> sisters)
	{
		this.sisters = sisters;
	}

	public Set<Habitant> getMarriagePartner()
	{
		return marriagePartner;
	}

	public void setMarriagePartner(Set<Habitant> marriagePartner)
	{
		this.marriagePartner = marriagePartner;
	}

	public Set<Habitant> getFriends()
	{
		return friends;
	}

	public void setFriends(Set<Habitant> friends)
	{
		this.friends = friends;
	}

	public Set<Habitant> getEnemies()
	{
		return enemies;
	}

	public void setEnemies(Set<Habitant> enemies)
	{
		this.enemies = enemies;
	}

	public Set<FavFood> getFavFoods()
	{
		return favFoods;
	}

	public void setFavFoods(Set<FavFood> favFoods)
	{
		this.favFoods = favFoods;
	}

	public Set<FavDrink> getFavDrinks()
	{
		return favDrinks;
	}

	public void setFavDrinks(Set<FavDrink> favDrinks)
	{
		this.favDrinks = favDrinks;
	}

	public Set<Hobby> getHobbies()
	{
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies)
	{
		this.hobbies = hobbies;
	}

	public Set<Fear> getFears()
	{
		return fears;
	}

	public void setFears(Set<Fear> fears)
	{
		this.fears = fears;
	}

	public float getWeight()
	{
		return weight;
	}

	public void setWeight(float weight)
	{
		this.weight = weight;
	}

	public String getMaidenName()
	{
		return maidenName;
	}

	public void setMaidenName(String maidenName)
	{
		this.maidenName = maidenName;
	}

	public String getOtherFacts()
	{
		return otherFacts;
	}

	public void setOtherFacts(String otherFacts)
	{
		this.otherFacts = otherFacts;
	}

	public Set<Habitant> getPastLoves()
	{
		return pastLoves;
	}

	public void setPastLoves(Set<Habitant> pastLoves)
	{
		this.pastLoves = pastLoves;
	}
}
