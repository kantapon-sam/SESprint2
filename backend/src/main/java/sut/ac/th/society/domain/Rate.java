package sut.ac.th.society.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "RATE")
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "score")
	@Range(min = 5, max = 15)
	private Long score;
	@Column(name = "point1")
	@Range(min = 1, max = 3)
	private Long point1;
	@Column(name = "point2")
	@Range(min = 1, max = 3)
	private Long point2;
	@Column(name = "point3")
	@Range(min = 1, max = 3)
	private Long point3;
	@Column(name = "point4")
	@Range(min = 1, max = 3)
	private Long point4;
	@Column(name = "point5")
	@Range(min = 1, max = 3)
	private Long point5;
	@ManyToOne
	@JoinColumn(name = "CLUB_ID", nullable = false)
	private Club club;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getPoint1() {
		return point1;
	}

	public void setPoint1(Long point1) {
		this.point1 = point1;
	}

	public Long getPoint2() {
		return point2;
	}

	public void setPoint2(Long point2) {
		this.point2 = point2;
	}

	public Long getPoint3() {
		return point3;
	}

	public void setPoint3(Long point3) {
		this.point3 = point3;
	}

	public Long getPoint4() {
		return point4;
	}

	public void setPoint4(Long point4) {
		this.point4 = point4;
	}

	public Long getPoint5() {
		return point5;
	}

	public void setPoint5(Long point5) {
		this.point5 = point5;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

}
