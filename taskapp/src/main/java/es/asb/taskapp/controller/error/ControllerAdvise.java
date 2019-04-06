package es.asb.taskapp.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import es.asb.taskapp.Exception.TaskException;
import es.asb.taskapp.Exception.ValidateTaskException;



@ControllerAdvice
public class ControllerAdvise {
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity handleApiException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(ValidateTaskException.class)
	public ResponseEntity handleValidateApiException(Exception ex) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(ex.getMessage());
	}

}
