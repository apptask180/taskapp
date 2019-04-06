package es.asb.taskapp.validator.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.asb.taskapp.Exception.ValidateTaskException;
import es.asb.taskapp.api.User;
import es.asb.taskapp.entity.UserEntity;
import es.asb.taskapp.repository.UserRepository;
import es.asb.taskapp.validator.UserValidateService;

@Service("userValidateServiceImpl")
public class UserValidateServiceImpl  implements UserValidateService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void validator(User user) throws ValidateTaskException {
		 validatorNull(user);
		 validatorNameAndEmailNotNull(user);
		 validatorPassword(user);
		 validatorEmail(user);
		 validatorName(user);
	}
	
	@Override
	public void  validatorNull(User user) throws ValidateTaskException {
		if(Objects.isNull(user)) {
			throw new ValidateTaskException("The User is null.");			
		}
		
	}

	@Override
	public void validatorName(User user) throws ValidateTaskException {
		List<UserEntity> users=userRepository.findByName(user.getName());
		if(users.size()>1) {
			throw new ValidateTaskException("The name not unique.");
		}
		
	}

	@Override
	public void validatorEmail(User user) throws ValidateTaskException {
		List<UserEntity> users=userRepository.findByEmail(user.getEmail());
		if(users.size()>1) {
			throw new ValidateTaskException("The Email not unique.");
		}
		
	}

	@Override
	public void validatorNameAndEmailNotNull(User user) throws ValidateTaskException {
		if(!(Objects.nonNull(user.getName()) && Objects.nonNull(user.getName()) &&
				!user.getEmail().isEmpty() && !user.getName().isEmpty())) {
			throw new ValidateTaskException("The Name or Email is bad.");				
		}
		
	}

	@Override
	public void validatorPassword(User user) throws ValidateTaskException {
		if(!(Objects.nonNull(user.getPassword()) && !user.getPassword().isEmpty())) {
			throw new ValidateTaskException("The password is Empty or null.");			
		}
		
	}

	@Override
	public void validatorUpdate(User user) throws ValidateTaskException {
		validator(user);
		if(Objects.isNull(user.getId())){
			throw new ValidateTaskException("The Id is null.");
		}
	}

	

}
