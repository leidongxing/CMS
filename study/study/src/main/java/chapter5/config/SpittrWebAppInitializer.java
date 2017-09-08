package chapter5.config;

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

}
