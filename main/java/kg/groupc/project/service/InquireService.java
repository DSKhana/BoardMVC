package kg.groupc.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import kg.groupc.project.dto.InquireDto;
import kg.groupc.project.entity.Account;
import kg.groupc.project.repository.AccountRepository;
import kg.groupc.project.repository.InquireRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InquireService {
	
	private InquireRepository inquireR;
	private final AccountRepository accountR;
	
	public Account getInquire(Account account) {
		if(!idDuplicateCheck(account.getUserId())) {
			return accountR.save(account);
		}else {
			return null;
		}
	}
	
	public boolean idDuplicateCheck(String userId) {
		Account account = accountR.findByUserId(userId);
		if(account == null)
			return false;
		else
			return true;
	}
	
	public Map<String, String> validateHandling(Errors errors){
		Map<String, String> validatorResult = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		
		return validatorResult;
	}
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		Account account = accountR.findByUserId(userId);
		
		if(account == null) {
			throw new UsernameNotFoundException(userId);
		}
		return User.builder()
				.username(account.getUserId())
				.password(account.getPassword())
				.roles(account.getRole().toString())
				.build();
	}
	
	
	
	public InquireRepository getRepository() {
		return inquireR;
	}
	
	public void setRepository(InquireRepository repository) {
		this.inquireR = repository;
	}
	
	// 문의 게시글 전체 조회
	public Page<InquireDto> getInquireList(Pageable pageable){
		return null;
	}
	
	//문의 게시글 등록
	public InquireDto write(InquireDto dto) {
		return null;
	}
	
	//글 번호로 해당 게시글 조회
	public InquireDto read(Long seq) {
		return null;
	}
	
	//글 번호로 해당 게시글 삭제
	public static int delete(InquireDto inquire) {
		return InquireRepository.delete(inquire);
	}
	
	//글 번호로 해당 게시글 수정
	public static InquireDto update(Long seq, InquireDto dto) {
		return null;
	}

	public void edit(InquireDto inquireDto) {
		// TODO Auto-generated method stub
		
	}

}