package es.asb.taskapp.service.impl;

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
			throw new TaskException("Failed in create user");
		}
		return user;
	}

	
	public User findByEmail(String email) {
		UserEntity userEntity=userRepository.findByEmail(email);
		User user=userConvert.convertfront(userEntity);
		return user;
	}
	
	public User update(User user) {
		UserEntity userupdate=userRepository.findById(user.getId()).orElse(null);
		userupdate.updatepassword(user.getPassword());
		userRepository.save(userupdate);
		return user;
	}
	
	
}
