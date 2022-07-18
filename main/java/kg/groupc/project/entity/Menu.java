package kg.groupc.project.entity;

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

@Entity
@Getter
@Setter
@ToString
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private long seq;
	
	// 식당 id(외래키)
	@ManyToOne(optional = false,targetEntity = Restaurant.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant")
	private long restaurant;
	
	// 메뉴 이름
	@Column(nullable = false, length = 50)
	private String name;
	
	// 메뉴 가격
	@Column(nullable = false)
	private long price;
	
	// 메뉴 설명 
	@Column(nullable = true, length = 1000)
	private String description;
	
	@Column(nullable = true, length = 255)
	private String img;
}
