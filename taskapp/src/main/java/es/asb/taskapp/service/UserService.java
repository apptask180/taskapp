package es.asb.taskapp.service;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.api.User;

public interface UserService {

	 public User create(User user) throws TaskException;
	 public User findByEmail(String email) throws TaskException;
	 public User update(User user)throws TaskException;
	 public User findByName(String name)throws TaskException;
	 public boolean login(User user)throws TaskException;
}
