package com.springboot.namedquery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "Topic.findByDescriptionSorted", query = "from Topic where description=?1 order by ticketPrice")
})
@NamedNativeQuery(name = "Topic.findTopicByNameSortedById", 
				   query = "select * from Topic t where t.name=?1 order by id desc" ,
				   resultClass=Topic.class
				)
@Entity
public class Topic {
	@Id

	private int id;

	private String name;
	
	private String description;
	
	private int ticketPrice;
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topic(int id, String name, String description, int ticketPrice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ticketPrice=ticketPrice;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + ", ticketPrice=" + ticketPrice
				+ "]";
	}
	
}
