package es.asb.taskapp.convert;

import org.springframework.stereotype.Component;

import es.asb.taskapp.api.User;
import es.asb.taskapp.entity.UserEntity;

@Component("userConvert")
public class UserConvert {

	public UserEntity convertback(User user) {
		UserEntity userEntity=new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setId(user.getId());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		return userEntity;
	}
	
	public User convertfront(UserEntity userEntity) {
		User user=new User();
		user.setName(userEntity.getName());
		user.setId(userEntity.getId());
		user.setEmail(userEntity.getEmail());
		user.setPassword(userEntity.getPassword());
		return user;
	}
	
}
