package sut.ac.th.society.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Council {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false,name = "username", length = 10)
	private String username;
	
	@Column(nullable = false,name = "password", length = 10)
	private String password;
	
	@Column(nullable = false,name = "firstname", length = 20)
	private String firstname;
	
	@Column(nullable = false,name = "surname" , length = 20)
	private String surname;
	
	@Column(nullable = false,name = "dateToApply1")
	private Date dateToApply1;
	
	@Column (nullable = false,name = "dateToApply2")
	private Date dateToApply2;
	
	@Column(nullable = false, name = "dateToCreate1")
	private Date dateToCreate1;
	
	@Column(nullable = false, name = "dateToCreate2")
	private Date dateToCreate2;
	
	@Column(columnDefinition = "ENUM('ฝ่ายกิจกรรม')")
	private String level;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateToApply1() {
		return dateToApply1;
	}

	public void setDateToApply1(Date dateToApply1) {
		this.dateToApply1 = dateToApply1;
	}

	public Date getDateToApply2() {
		return dateToApply2;
	}

	public void setDateToApply2(Date dateToApply2) {
		this.dateToApply2 = dateToApply2;
	}

	public Date getDateToCreate1() {
		return dateToCreate1;
	}

	public void setDateToCreate1(Date dateToCreate1) {
		this.dateToCreate1 = dateToCreate1;
	}

	public Date getDateToCreate2() {
		return dateToCreate2;
	}

	public void setDateToCreate2(Date dateToCreate2) {
		this.dateToCreate2 = dateToCreate2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
