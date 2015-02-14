package sut.ac.th.society.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Club {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, name = "user_name", length = 30)
	@Size(min = 5, max = 30)
	private String userName;
	@Column(nullable = false, name = "name", length = 30)
	private String name;
	@Column(nullable = false, name = "last_name", length = 30)
	private String lastName;
	@Column(length = 15, nullable = false, name = "pass_word")
	@Size(min = 5, max = 30)
	private String passWord;
	@Column(nullable = false, name = "level", columnDefinition = "ENUM('»ÃÐ¸Ò¹ªÁÃÁ')")
	private String level;
	@Column(nullable = false, name = "nameclub", length = 30)
	private String nameclub;
	@Column(nullable = false, length = 200, name = "description")
	private String description;
	@Column(nullable = false, length = 30, name = "place")
	private String place;
	@Column(nullable = false, name = "advisor", length = 30)
	private String advisor;
	@Column(name = "amount")
	@Min(1)
	private Long amount;
	@Column(name = "register")
	@Min(0)
	private Long register;
	@OneToMany
	private Collection<Student> students;

	@OneToMany
	private Collection<Comment> comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNameclub() {
		return nameclub;
	}

	public void setNameclub(String nameclub) {
		this.nameclub = nameclub;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAdvisor() {
		return advisor;
	}

	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getRegister() {
		return register;
	}

	public void setRegister(Long register) {
		this.register = register;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}

}
