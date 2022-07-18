package kg.groupc.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 호텔
@Entity
@Getter
@Setter
@ToString
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private long seq;
	
	// 호텔명
	@Column(nullable = false, length = 50)
	private String name;
	
	// 호텔 전화번호
	@Column(nullable = false, length = 20)
	private String phone;
	
	// 호텔 주소
	@Column(nullable = false, length = 100)
	private String address;
	
	// 호텔 설명
	@Column(nullable = true, length = 1000)
	private String description;
	
	// 호텔 이미지
	@Column(nullable = true, length = 255)
	private String img;
	
	// 호텔 상태(0 = 폐점), 기본적으로 1
	@Column(nullable = false, columnDefinition = "number(1) default 1")
	private long status;
}
