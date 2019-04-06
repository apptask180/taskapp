package es.asb.taskapp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
@ComponentScan(basePackages = {"es.asb.taskapp"})
@Import(value = {DatabaseConfig.class})
public class AppConfig {

//	@Bean
//	public DozerBeanMapper dozerMapper() {
//		DozerBeanMapper mapper = new DozerBeanMapper();
//		List myMappingFiles = new ArrayList();
//		myMappingFiles.add("mappingdozer.xml");
//		mapper.setMappingFiles(myMappingFiles);
//		return mapper;
//	}
	
	@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);
         
        mailSender.setUsername("apptask180@gmail.com");
        mailSender.setPassword("1234abcdABCD");
         
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
         
        return mailSender;
    }
	  
  
}
