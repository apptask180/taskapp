package es.asb.taskapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.api.User;
import es.asb.taskapp.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String init() {
		return "hola";
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user ) throws TaskException {
		user=userService.create(user);
		
		return user;
	}
	
	@PostMapping
	public Boolean login(@RequestBody User user)throws TaskException{
		User userfounded=userService.findByEmail(user.getEmail());
		boolean passlogin=false;
		if(userfounded.getPassword().equals(user.getPassword())) {
			passlogin=true;
		}
		
		return passlogin;
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user)throws TaskException{
		user=userService.update(user);
		return user;
	}
	
}
