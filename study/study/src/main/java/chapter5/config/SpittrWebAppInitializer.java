package chapter5.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	// 带有@Configuration的定义ContextLoaderListener应用上下文的bean
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	// 带有@Configuration的定义ConfigDispatchServlet应用上下文的bean
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
    
	@Override
	protected Filter[] getServletFilters(){
		return null;
		
	}
	
	@Override 
	protected void customizeRegistration(Dynamic registration){
		registration.setMultipartConfig(
		        new MultipartConfigElement("", 2097152, 4194304, 0));
	}
}
