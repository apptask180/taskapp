package es.asb.taskapp.dummy;

import org.springframework.stereotype.Component;

import es.asb.taskapp.entity.UserEntity;

@Component("dummyUserEntity")
public class DummyUserEntity {

	public UserEntity build() {
		UserEntity userEntity=new UserEntity();
		userEntity.setName("Antonio Jesús");
		userEntity.setEmail("ajsobrino700@gmail.com");
		userEntity.setPassword("12345");
		return userEntity;
	}
	
}
