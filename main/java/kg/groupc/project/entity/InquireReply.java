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

@Entity
@Getter
@Setter
@ToString
public class InquireReply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private long seq;
	
	// 문의글 id(외래키)
	@ManyToOne(optional = false, targetEntity = Inquire.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "inquire")
	private long inquire;
	
	// 작성자(관리자, 외래키)
	@ManyToOne(optional = false, targetEntity = Account.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "admin")
	private String admin;
	
	// 제목
	@Column(nullable = false, length = 30)
	private String title;
	
	// 내용
	@Column(nullable = false, length = 1000)
	private String description;
	
	// 작성일
	@Column(nullable = false)
	private Date day;
}
