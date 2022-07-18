package kg.groupc.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 맛집
@Entity
@Getter
@Setter
@ToString
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long seq;
	
	// 점포 이름
	@Column(nullable = false, length = 50)
	private String name;
	
	// 점포 주소
	@Column(nullable = false, length = 100)
	private String address;
	
	// 점포 전화번호
	@Column(nullable = false, length = 20)
	private String phone;
	
	// 점포 이미지
	@Column(nullable = true, length = 255)
	private String img;
	
	// 점포 상태
	@Column(nullable = false, columnDefinition = "number(1) default 1")
	private long status;
	
	// 점포 설명
	@Column(nullable = true, length = 1000)
	private String description;
}
