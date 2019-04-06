package es.asb.taskapp.dummy;

import org.springframework.stereotype.Component;

import es.asb.taskapp.api.User;

@Component
public class DummyUser {

	public User build() {
		User user=new User();
		user.setName("juanjo");
		user.setEmail("ajsobrino700@gmail.com");
		return user;
	}
	
	
}
