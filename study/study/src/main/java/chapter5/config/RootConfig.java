package chapter5.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
		basePackages={"chapter5"},
		excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)}
		)
@Import(DruidDataSourceConfig.class)
public class RootConfig {
   public static class WebPackage extends RegexPatternTypeFilter{
	   public WebPackage(){
		   super(Pattern.compile("spittr\\.web"));
	   }
   }
  
}
