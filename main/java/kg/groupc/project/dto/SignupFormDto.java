package kg.groupc.project.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormDto {
	@NotBlank(message = "이름을 입력해주세요.")
	private String username;
	
	@NotBlank(message = "아이디는 필수 입력사항입니다.")
	@Pattern(regexp = "^[a-z][a-z0-9]{7,15}$", message = "아이디가 올바르지 않습니다. 다시 입력해주세요.")
	private String userId;
	
	@NotBlank(message = "비밀번호는 필수 입력사항입니다.")
	@Pattern(regexp = "^^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{12,20}$", message = "올바르지 않은 비밀번호입니다. 다시 입력해주세요.")
	private String password;
	
	@NotBlank(message = "비밀번호 확인을 입력해주세요.")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{12,20}$$",
			message = "비밀번호 확인이 잘못되었습니다. 다시 입력해주세요.")
	private String passwordCheck;
	
	@NotBlank(message = "이메일을 입력해주세요.")
	@Email(message = "이메일 형식이 올바르지 않습니다.")
	private String email;
	
	@NotBlank(message = "핸드폰 번호를 입력해주세요.")
	@Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message = "핸드폰 번호 형식이 잘못되었습니다.")
	private String phone;
	
	@NotBlank(message = "주소를 검색해주세요.")
	private String address;
	
	@NotBlank(message = "세부 주소를 입력해주세요.")
	private String addressDetail;
	
	@NotBlank(message = "생년월일을 입력해주세요.")
	@Pattern(regexp = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$", message = "yyyymmdd 형식으로 입력해주세요. ex) 20220101")
	private String birth;
}
