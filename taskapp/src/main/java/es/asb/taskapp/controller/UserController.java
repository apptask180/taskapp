package es.asb.taskapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.Exception.ValidateTaskException;
import es.asb.taskapp.api.User;
import es.asb.taskapp.service.UserService;
import es.asb.taskapp.validator.UserValidateService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserValidateService validatorUser;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user ) throws TaskException, ValidateTaskException {
		validatorUser.validator(user);
		user=userService.create(user);
		return user;
	}
	
	@PostMapping
	public Boolean login(@RequestBody User user)throws TaskException, ValidateTaskException{
		validatorUser.validatorNull(user);
		validatorUser.validatorPassword(user);

		return userService.login(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user)throws TaskException, ValidateTaskException{
		validatorUser.validatorUpdate(user);
		user=userService.update(user);
		return user;
	}
	
}
