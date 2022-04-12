package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hallId;

}
