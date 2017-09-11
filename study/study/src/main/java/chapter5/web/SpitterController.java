package chapter5.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String processRegistration(@Valid Spitter spitter,Errors errors) {
		if(errors.hasErrors()){
			return "redirect";
		}
		spitterRepository.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=GET)
	public String showSpitterProfile(@PathVariable String username,Model model){
		Spitter spitter =spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
