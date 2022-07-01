package web.spring.board.domain;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("BoardVO")
public class BoardVO {
	private int seq;
	@Length(min=2, max=5, message="제목은 2~5자 사이로 입력해야 합니다")
	private String title;
	@NotEmpty(message="내용을 입력하세요.")
	private String content;
	@NotEmpty(message="작성자를 입력하세요.")
	private String writer;
	@NotNull(message="비밀번호를 입력하세요.")
	private int password;
	private Timestamp regDate;
	private int cnt;
	
	public BoardVO() {}
	
	public BoardVO(String title, String content, String writer, int password) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.cnt = 0;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
