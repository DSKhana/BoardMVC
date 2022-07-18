package kg.groupc.project.dto;

import java.sql.Timestamp;
import org.modelmapper.ModelMapper;

import kg.groupc.project.entity.Inquire;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InquireDto {
	
	private Long seq;
	private String category;
	private String hotel;
	private String title;
	private String writer;
	private String description;
	private Timestamp regDate;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static Inquire of (Inquire inquire) {
		return modelMapper.map(inquire, Inquire.class);
	}
	
	public InquireDto() {}

	public InquireDto(Long seq, String category, String hotel, 
			String title, String writer, String description,
			Timestamp regDate) {
		super();
		this.seq = seq;
		this.category = category;
		this.hotel = hotel;
		this.title = title;
		this.writer = writer;
		this.description = description;
		this.regDate = regDate;
	}

}
