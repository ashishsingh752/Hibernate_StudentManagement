package com.lcwd.hibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")

public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "Student Name", length = 100, unique = true)
	private String name;
	
	@Column(name = "College Name", length = 200, nullable = true)
	private String collegeName;
	
	@Column(name = "Father Name", length = 100)
	private String father;
	
	@Column(name = "Phone No.", length = 12, unique = true)
	private String phone;
	
	@Column(name = "Status")
	private boolean active=true;
	
	@Lob
	private String about;
	
	 
	
}
