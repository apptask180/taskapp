package es.asb.taskapp.config;

import java.util.Properties;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Ignore
public class BaseIntegrationTest {

//	@Bean
//	public DozerBeanMapper dozerMapper() {
//		DozerBeanMapper mapper = new DozerBeanMapper();
//		List myMappingFiles = new ArrayList();
//		myMappingFiles.add("mappingdozer.xml");
//		mapper.setMappingFiles(myMappingFiles);
//		return mapper;
//	}
	
//	@Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(25);
//         
//        mailSender.setUsername("name");
//        mailSender.setPassword("password");
//         
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//         
//        return mailSender;
//    }
	
}
