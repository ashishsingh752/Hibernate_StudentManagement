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

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "student_name", length = 100)
	private String name;

	@Column(name = "college_name", length = 200)
	private String collegeName;

	@Column(name = "father_name", length = 100)
	private String father;

	@Column(name = "phone_no", length = 12, unique = true)
	private String phone;

	@Column(name = "status")
	private boolean active = true;

	@Lob
	private String about;

	
	public Student() {};

	public Student(Long id, String name, String collegeName, String father, String phone, boolean active,
			String about) {
		super();
		this.id = id;
		this.name = name;
		this.collegeName = collegeName;
		this.father = father;
		this.phone = phone;
		this.active = active;
		this.about = about;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
		
	 
	
}
