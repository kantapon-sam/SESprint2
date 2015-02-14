package sut.ac.th.society.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true,name = "idStudent",nullable = false)
	@Size(max = 8,min = 8)
	@Pattern(regexp = "[BMD]\\d{7}")
	private String idStudent;
	
	@Column(nullable = false,name = "firstname", length = 15)
	private String firstname;
	
	@Column(nullable = false,name = "surname")
	private String surname;

	@Column(nullable = false,name = "year")
	@Min(1)
	@Max(4)
	private Long year;
	
	@Column(nullable = false,name = "faculty",length = 30)
	private String faculty; 
	
	@Column(nullable = false,name = "department",length = 30)
	private String department;
	
	@OneToOne
	private Club club;
	
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

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	
}
