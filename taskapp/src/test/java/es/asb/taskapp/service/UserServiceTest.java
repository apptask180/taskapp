package es.asb.taskapp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.api.User;
import es.asb.taskapp.config.BaseIntegrationTest;
import es.asb.taskapp.dummy.DummyUser;

public class UserServiceTest extends BaseIntegrationTest {

	@Autowired
	private DummyUser dumyUser;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void createTest() throws TaskException {
		User user=dumyUser.build();
		user=userService.create(user);
	}
	
}
