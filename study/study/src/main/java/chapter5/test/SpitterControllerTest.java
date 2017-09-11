package chapter5.test;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;


import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import chapter5.data.SpitterRepository;
import chapter5.pojo.Spitter;
import chapter5.web.SpitterController;

public class SpitterControllerTest {
   @Test
   public void shouldShowRegistration() throws Exception{
	   SpitterController controller = mock(SpitterController.class);
//	   SpitterController controller = new SpitterController();
	   MockMvc  mockMvc = standaloneSetup(controller).build();
	   mockMvc.perform(get("/spitter/register"))
	          .andExpect(view().name("registerForm"));
   }
   
   @Test
   public void shouldProcessRegistration() throws Exception{
	   SpitterRepository mockRepository = mock(SpitterRepository.class);
	   Spitter unsaved = new Spitter(213L,"zhangwj","dd","jack","ma","jack@alibab.com");
	   Spitter saved = new Spitter(213L,"zhangwj","dd","jack","ma","jack@alibab.com");
	   when(mockRepository.save(unsaved)).thenReturn(saved);
	   SpitterController controller = new SpitterController(mockRepository);
	   MockMvc mockMvc = standaloneSetup(controller).build();
	   mockMvc.perform(post("/spitter/register")
			   .param("firstName", "Jack")
			   .param("lastName","ma")
			   .param("username","zhangwj")
			   .param("password","dd"))
			   .andExpect(redirectedUrl("/spitter/zhangwj"));
	   verify(mockRepository,atLeastOnce()).save(unsaved);
   }
}
