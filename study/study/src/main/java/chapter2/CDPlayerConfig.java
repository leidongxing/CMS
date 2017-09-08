package chapter2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@Configuration
//@ComponentScan(basePackages={"chapter2","chapter1"})
//@ComponentScan(basePackageClasses={BlankDisc.class})


@Configuration
@ImportResource("classPath:chapter2.xml")
public class CDPlayerConfig {
	
}
