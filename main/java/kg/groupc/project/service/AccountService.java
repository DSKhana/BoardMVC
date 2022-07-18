package kg.groupc.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import kg.groupc.project.entity.Account;
import kg.groupc.project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{
	
	private final AccountRepository accountRepository;
	
	public Account saveAccount(Account account) {
		if(!idDuplicateCheck(account.getUserId())) {
			return accountRepository.save(account);
		}else {
			return null;
		}
	}
	
	public boolean idDuplicateCheck(String userId) {
		Account account = accountRepository.findByUserId(userId);
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
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Account account = accountRepository.findByUserId(userId);
		
		if(account == null) {
			throw new UsernameNotFoundException(userId);
		}
		return User.builder()
				.username(account.getUserId())
				.password(account.getPassword())
				.roles(account.getRole().toString())
				.build();
	}
}
