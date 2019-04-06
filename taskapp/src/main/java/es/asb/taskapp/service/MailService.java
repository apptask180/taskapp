package es.asb.taskapp.service;

import es.asb.taskapp.api.User;

public interface MailService {

	public  boolean sendMail(String to,String subject,String msg);
	 
}
