package com.example.ENOTES.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Note {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
    //Hibernate: create table notes (id integer not null auto_increment, date date, description varchar(255), title varchar(255), user_id integer, primary key (id)) engine=InnoDB
   //// Hibernate: alter table notes add constraint FKsncua5ftnqcfg0q2pg8ylcs3x foreign key (user_id) references user (id)
  //  Hibernate: insert into notes (date,description,title,user_id) values (?,?,?,?)
    @Column
	private String title;
    @Column
	private String description;
    @Column
	private LocalDate date;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	
}
