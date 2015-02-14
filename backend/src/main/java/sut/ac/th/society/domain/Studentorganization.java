package sut.ac.th.society.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studentorganization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "publishsubscribe", nullable = false)
	private String publishsubscribe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublishsubscribe() {
		return publishsubscribe;
	}

	public void setPublishsubscribe(String publishsubscribe) {
		this.publishsubscribe = publishsubscribe;
	}

	
}
