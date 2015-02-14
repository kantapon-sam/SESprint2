package sut.ac.th.society.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false,name = "money")
	@Min(0)
	private Long money;

	@OneToOne
	private Club club;
	

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


	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	

}
