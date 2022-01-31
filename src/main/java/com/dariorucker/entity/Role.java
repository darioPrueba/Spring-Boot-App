package com.dariorucker.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Role implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 2618751047772493017L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@GenericGenerator(name="native", strategy="native")
private Long id;	
	
@Column
private String name;

@Column
private String description;


}
