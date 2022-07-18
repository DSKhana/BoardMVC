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

// 예약
@Entity
@Getter
@Setter
@ToString
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private long seq;
	
	// 방 id(외래키)
	@ManyToOne(optional = false, targetEntity = Room.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "room")
	private long room;
	
	// 예약자(외래키)
	@ManyToOne(optional = false, targetEntity = Account.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "reserver")
	private String reserver;
	
	// 예약일
	@Column(nullable = false)
	private Date reserveDate;
	
	// 예약 종료일
	@Column(nullable = false)
	private Date reserveEndDate;
	
	// 예약 상태
	@Column(nullable = false, columnDefinition = "number(1) default 1")
	private long status;
	
	// 가격
	@Column(nullable = false)
	private long price;
	
	// 인원 수
	@Column(nullable = false)
	private long people;
}
