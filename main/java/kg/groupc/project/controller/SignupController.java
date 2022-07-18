package kg.groupc.project.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kg.groupc.project.dto.SignupFormDto;
import kg.groupc.project.entity.Account;
import kg.groupc.project.service.AccountService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignupController {
	private final AccountService accountService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String getSignup() {
		return "/signup/signupForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@Valid SignupFormDto signupFormDto, Errors errors, Model model) {
		// 입력에 에러가 있다면
		if(errors.hasErrors()) {
			// 입력 데이터 값 유지
			model.addAttribute("signupFormDto", signupFormDto);
			// 입력값 유효성 검사
			Map<String, String> validatorResult = accountService.validateHandling(errors);
			for(String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
			return "/signup/signupForm";
		}
		Account account = Account.createAccount(signupFormDto, passwordEncoder);
		System.out.println(account);
		accountService.saveAccount(account);
		return "redirect:/";
	}
	
	@PostMapping("/signup/dupCheck")
	@ResponseBody
	public boolean dupCheck(String userId, boolean result) {
		if(!accountService.idDuplicateCheck(userId)) {
			return true;
		}
		return false;
	} 
}
