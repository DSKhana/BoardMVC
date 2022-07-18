package kg.groupc.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import kg.groupc.project.dto.InquireDto;
import kg.groupc.project.service.AccountService;
import kg.groupc.project.service.InquireService;

@Controller
public class InquireController {
	@Autowired
	private InquireService inquireService;
	
	@SuppressWarnings("unused")
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value="/inquire")
	public String list(Model model) {
		model.addAttribute("inquire", inquireService.getInquireList(null));
		return "/inquire/inquire";
	}
	
	@GetMapping(value="/inquire/read/{seq}")
	public String read(Model model, @PathVariable Long seq) {
		model.addAttribute("inquireDto", inquireService.read(seq));
		return "/inquire/read";
	}
	
	@GetMapping(value="/inquire/write")
	public String write(Model model) {
		model.addAttribute("inquireDto", new InquireDto());
		return "/inquire/inquireWriteForm";
	}
	
	@PostMapping(value="/inquire/write")
	public String write(InquireDto dto, BindingResult br) {
		if(br.hasErrors()) {
			return "/inquire/inquireWriteForm";
		}
		inquireService.write(dto);
		return "redirect:/inquire/inquire";
	}
	
	@GetMapping(value="/inquire/edit/{seq}")
	public String edit(@PathVariable long seq, Model model) {
		InquireDto dto = inquireService.read(seq);
		model.addAttribute("inquireDto", inquireService);
		return"/inquire/edit";
	}
	
	@PostMapping(value="inquire/edit/{seq}")
	public String edit(@ModelAttribute InquireDto inquireDto, BindingResult result,
			SessionStatus sessionStatus, Model model) {
		if(result.hasErrors()) {
			return "inquire/edit";
		}
		else {
			if(inquireDto.getWriter() == write(null)) {
				inquireService.edit(inquireDto);
				
			}
		}
		return "/inquire/edit";
	}
	
	@GetMapping(value="inquire/delete/{seq}")
	public String delete(@PathVariable long seq, Model model) {
		model.addAttribute("seq", seq);
		return "inquire/delete";
	}
	
	@SuppressWarnings("static-access")
	@PostMapping(value="inquire/delete/{seq}")
	public String delete(long seq, String writer, Model model) {
		int rowCount;
		InquireDto inquire = new InquireDto();
		inquire.setSeq(seq);
		inquire.setWriter(writer);
		
		rowCount = inquireService.delete(inquire);
		
		if(rowCount == 0) {
			model.addAttribute("seq", seq);
			model.addAttribute("msg", "");
			return "/inquire/delete";
		}
		else {
			return "redirect:/inquire/inquire";
		}
	}
}