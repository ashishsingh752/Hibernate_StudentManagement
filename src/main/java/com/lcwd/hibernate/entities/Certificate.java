package com.lcwd.hibernate.entities;

import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_certificate")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Certificate_Id")
	private long certificateId;
	
	@Column(name = "Title", length = 100)
	private String title;
	
	@Column(name = "About", length = 100)
	private String about ;
	
	@Column(name = "Link", length = 100)
	private String link;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	public Certificate() {};
	
	public Certificate(long certificateId, String title, String about, String link) {
		super();
		this.certificateId = certificateId;
		this.title = title;
		this.about = about;
		this.link = link;
	}

	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
		this.certificateId = certificateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}



