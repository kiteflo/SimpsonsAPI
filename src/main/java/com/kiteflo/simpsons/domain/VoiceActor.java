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
 * Real life voice actor for Simpsons character...
 */
@NodeEntity
@XmlRootElement
public class VoiceActor
{
	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------
	
	@GraphId
	private Long id;
	
	private String firstname;
	private String lastname;
	
	// image URL
	private String imageURL;
	
	@RelatedTo(type = Relationships.WEBLINKS, direction = Direction.OUTGOING)
	private Set<Webpage> weblinks = new HashSet<Webpage>();
	
	// ------------------------------------------------------------------------
	// overridden stuff
	// ------------------------------------------------------------------------
	
	@Override
	public String toString()
	{
		return firstname + " " + lastname;
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

	public Set<Webpage> getWeblinks()
	{
		return weblinks;
	}

	public void setWeblinks(Set<Webpage> weblinks)
	{
		this.weblinks = weblinks;
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
}
