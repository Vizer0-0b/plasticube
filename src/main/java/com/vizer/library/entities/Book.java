package com.vizer.library.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vizer.plasticube.entities.User;


@Entity
@Table(name="book")
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String isbn;
    private String name;

    private String author;
    private String publishingCompany;
    private Float price;
    private String description;
    private Date publishingDate; // sql.date util.date.getTime()
    
    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    private User currentUser;
    
    private String statue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}
    /*
     * 
    private String isbn;
    private String name;

    private String author;
    private String publishingCompany;
    private String price;
    private String discripe;
    private Date publishingDate; 	
     * */
	public Book(){}
	public Book(	String isbn, 
			String name, 
			String author, 
			String publishingCompany, 
			Float price, 
			String description, 
			Date   publishingDate,
			User cuser){
		this.id=-1;
		this.isbn=isbn;
		this.name=name;
		this.author=author;
		this.publishingCompany=publishingCompany;
		this.price=price;
		this.description=description;
		this.publishingDate=publishingDate;
		this.currentUser=cuser;
	}
}
    