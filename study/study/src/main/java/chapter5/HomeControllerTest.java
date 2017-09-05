package chapter5;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Date;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {
   @Test
   public void testHomePage() throws Exception{
	   HomeController controller = new HomeController();
	   MockMvc mockMvc= standaloneSetup(controller).build();
	   mockMvc.perform(get("/")).andExpect(view().name("home"));  
	   
	   Spittle s1= new Spittle("1",new Date(10000L));
	   Spittle s2= new Spittle("2",new Date(10000L));
	   System.out.println(s1.equals(s2));
	   
   }
}
