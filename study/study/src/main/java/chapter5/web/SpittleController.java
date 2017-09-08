package chapter5.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import chapter5.data.SpittleRepository;

@Controller
@RequestMapping(value="/spittles")
public class SpittleController {
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
}
