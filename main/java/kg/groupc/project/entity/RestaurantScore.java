package kg.groupc.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 맛집 리뷰
@Entity
@Getter
@Setter
@ToString
public class RestaurantScore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;
	
	// 점포 id(외래키)
	@ManyToOne(optional = false, targetEntity = Restaurant.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	private long restaurant;
	
	// 작성자
	@ManyToOne(optional = false, targetEntity = Account.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "writer")
	private String writer;
	
	// 리뷰 평점
	@Column(nullable = false)
	private long score;
	
	// 리뷰 내용
	@Column(nullable = true, length = 1000)
	private String description;
	
	// 작성일
	@Column(nullable = false)
	private Date day;
}
