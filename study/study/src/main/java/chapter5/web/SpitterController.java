package chapter5.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import chapter5.data.SpitterRepository;
import chapter5.pojo.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;

	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}

	@RequestMapping(value = "/register", method=GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value ="/register",method=POST)
	public String processRegistration(
			@RequestPart(value="image",required=false) MultipartFile mf,
			@Valid Spitter spitter,
			Errors errors) throws IllegalStateException, IOException {
		if(errors.hasErrors()){
			return "redirect";
		}
		mf.transferTo(new File("C:\\Users\\Administrator\\Desktop\\"+mf.getOriginalFilename()));
		//spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=GET)
	public String showSpitterProfile(@PathVariable String username,Model model){
		Spitter spitter =spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	
	
}
