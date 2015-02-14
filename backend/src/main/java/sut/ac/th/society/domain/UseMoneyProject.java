package sut.ac.th.society.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
public class UseMoneyProject {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false,name = "money")
	@Min(0)
	private Long money;
	
	@Column(nullable = false)
	private String usemoney;
	
	@OneToOne
	private Project project;
	

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getUsemoney() {
		return usemoney;
	}

	public void setUsemoney(String usemoney) {
		this.usemoney = usemoney;
	}

	
	
	
}