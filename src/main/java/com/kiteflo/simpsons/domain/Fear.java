package com.kiteflo.simpsons.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Fear representation...
 */
@NodeEntity
@XmlRootElement
public class Fear
{
	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------
	
	@GraphId
	private Long id;

	@Indexed(indexType=IndexType.UNIQUE, indexName="INDEX_FEAR")
	private String name;
	private String description;
	private String imageURL;
	
	// ------------------------------------------------------------------------
	// GETTER & SETTER
	// ------------------------------------------------------------------------
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
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
