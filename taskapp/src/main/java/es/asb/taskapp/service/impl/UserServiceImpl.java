package es.asb.taskapp.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.api.User;
import es.asb.taskapp.convert.UserConvert;
import es.asb.taskapp.entity.UserEntity;
import es.asb.taskapp.repository.UserRepository;
import es.asb.taskapp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConvert userConvert;

	@Override
	public User create(User user) throws TaskException {

		try {
			UserEntity userEntity = userConvert.convertback(user);
			userEntity = userRepository.save(userEntity);
			user = userConvert.convertfront(userEntity);
		} catch (Exception e) {
			LOG.error("Error, When it try create", e);
			throw new TaskException("Create user failed");
		}
		return user;
	}

	
	public User findByEmail(String email) throws TaskException {
		try {
			List<UserEntity> usersEntity=userRepository.findByEmail(email);
			User user=userConvert.convertfront(usersEntity.get(0));
			return user;
		}catch(Exception e) {
			LOG.error("Error, When it try create", e);
			throw new TaskException("Failed when findByEmail, user.");
		}
			
	}
	
	public User findByName(String name) throws TaskException {
		try {
			List<UserEntity> usersEntity=userRepository.findByName(name);
			User user=userConvert.convertfront(usersEntity.get(0));
			return user;
		}catch(Exception e) {
			LOG.error("Error, When it try create", e);
			throw new TaskException("Failed when findByName, user.");
		}
	}
	
	public User update(User user) throws TaskException {
		try {
			UserEntity userupdate=userRepository.findById(user.getId()).orElse(null);
			userupdate.updatepassword(user.getPassword());
			userRepository.save(userupdate);
			return user;
		}catch(Exception e) {
			LOG.error("Error, When it try create", e);
			throw new TaskException("Update User failed.");
		}
	}
	
	public boolean login(User user) throws TaskException {
		try {
			User userLogin=new User();
			boolean login=false;
			if(Objects.nonNull(user.getEmail())) {
				userLogin=findByEmail(user.getEmail());
				if(user.getPassword().equals(userLogin.getEmail())) {
					login=true;
				}
			}else {
				userLogin=findByName(user.getName());
				if(user.getPassword().equals(userLogin.getEmail())) {
					login=true;
				}
			}
			return login;
		}catch(Exception e) {
			LOG.error("Error, When it try create", e);
			throw new TaskException("Failed in Login.");
		}
		
	}
	
	
}
