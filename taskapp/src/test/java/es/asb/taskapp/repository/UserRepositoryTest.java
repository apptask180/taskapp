package es.asb.taskapp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.asb.taskapp.config.BaseIntegrationTest;
import es.asb.taskapp.dummy.DummyUserEntity;
import es.asb.taskapp.entity.UserEntity;

public class UserRepositoryTest extends BaseIntegrationTest{

	private static final Logger LOG=Logger.getLogger(UserRepository.class);
	
	@Autowired
	private DummyUserEntity dummyUserEntity;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createTest() {
		UserEntity userEntity=dummyUserEntity.build();
		userEntity=userRepository.save(userEntity);
		LOG.info(userEntity);
	}
	
	@Test
	public void findByIdTest() {
		UserEntity userEntity=dummyUserEntity.build();
		userRepository.save(userEntity);
		UserEntity userfounded=userRepository.findById(Long.valueOf(1)).orElse(null);
		assertEquals(userfounded.getId(), Long.valueOf(1));
		assertEquals(userfounded.getName(),userEntity.getName());
	}
	
	@Test
	public void findByIdfailTest() {
		
		UserEntity userfounded=userRepository.findById(Long.valueOf(1)).orElse(null);
		assertNull(userfounded);
	}
	
	
	@Test
	public void updateTest() {
		UserEntity userEntity=dummyUserEntity.build();
		userRepository.save(userEntity);
		UserEntity userfounded=userRepository.findById(Long.valueOf(1)).orElse(null);
		userfounded.setName("Juanito Makande");
		userEntity=userRepository.save(userEntity);
		LOG.info(userEntity);
	}
	
	
}
