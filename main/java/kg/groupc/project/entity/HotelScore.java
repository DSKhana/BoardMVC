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

// 호텔 리뷰
@Entity
@Getter
@Setter
@ToString
public class HotelScore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private long seq;
	
	// 호텔 id(외래키)
	@ManyToOne(optional = false, targetEntity = Hotel.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel")
	private long hotel;
	
	// 작성자(외래키)
	@ManyToOne(optional = false, targetEntity = Account.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "writer")
	private String writer;
	
	// 리뷰 평점
	@Column(nullable = false)
	private long score;
	
	// 리뷰 글 내용
	@Column(nullable = true, length = 1000)
	private String description;
	
	// 작성일
	@Column(nullable = false)
	private Date day;
}
