package chapter5.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

@Configuration
@Import(DruidDataSourceConfig.class)
@ComponentScan(basePackages={"chapter5.data","chapter5.pojo"})
public class RootConfig {
   public static class WebPackage extends RegexPatternTypeFilter{
	   public WebPackage(){
		   super(Pattern.compile("spittr\\.web"));
	   }
   }
	
  
}
