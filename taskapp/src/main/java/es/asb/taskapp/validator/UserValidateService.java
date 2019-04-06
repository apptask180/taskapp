package es.asb.taskapp.validator;

import es.asb.taskapp.Exception.ValidateTaskException;
import es.asb.taskapp.api.User;

public interface UserValidateService {
	
	public void validator(User user)throws ValidateTaskException;
	public void validatorNull(User user)throws ValidateTaskException;
	public void validatorName(User user)throws ValidateTaskException;
	public void validatorEmail(User user)throws ValidateTaskException;	
	
	public void validatorNameAndEmailNotNull(User user)throws ValidateTaskException;	
	public void validatorPassword(User user)throws ValidateTaskException;	
	
	public void validatorUpdate(User user)throws ValidateTaskException;
}
