package ru.springdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Sputnik")
@Setter
@Getter
public class Sputnik {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="sputnik")
	private String sputnik;
	
	
	@ManyToOne 
	@JoinColumn(name = "planetid")
	private Planet planet;


	@Override
	public String toString() {
		return "Sputnik id=" + id + ", sputnik=" + sputnik + " planet=" + planet.getPlanet();
	}
	
	

}
