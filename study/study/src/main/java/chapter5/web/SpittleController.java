package chapter5.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import chapter5.data.SpittleRepository;
import chapter5.pojo.Spittle;

@Controller
@RequestMapping(value="/spittles")
public class SpittleController {
	 private static final String MAX_LONG_AS_STRING ="9223372036854775807";
     private SpittleRepository spittleRepository;
     
     @Autowired
     public SpittleController(SpittleRepository spittleRepository){
    	 this.spittleRepository = spittleRepository;
     }
     
     @RequestMapping(method={GET,POST})
     public String spittle(Model model){
//    	 model.addAttribute( spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    	 model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    	 return "spittles";
     }
     
     public String spittle(
    		 @PathVariable("spittleId") long spittleId,
    		 Model model){
    	 Spittle spittle = spittleRepository.findOne(spittleId);
    	 if(spittle==null){
    		 throw new SpittleNotFoundException();
    	 }
    	 model.addAttribute(spittle);
    	 return "spittle";
     }
     
     public List<Spittle> spittles(
    		 @RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING) long max, 
    		 @RequestParam(value="count",defaultValue="20") int count){
    	 return spittleRepository.findSpittles(max, count);
     }
     
     @RequestMapping(value="/{spittleId}",method=GET)
     public String showSpittle(
    		 @RequestParam("spittleId") 
             @PathVariable long spittleId,
    		 Model model){
    	 model.addAttribute(spittleRepository.findOne(spittleId));
    	 return "spittle"; 	  
     }
     
     @RequestMapping(method=POST)
     public String saveSpittle(Spittle spittle,Model model){
			 spittleRepository.save(spittle);
			 return "redirect:/spittles";
     }
}
