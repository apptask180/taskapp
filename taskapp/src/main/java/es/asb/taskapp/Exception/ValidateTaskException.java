package es.asb.taskapp.Exception;

public class ValidateTaskException extends Exception{

	public ValidateTaskException() {
		super();
	}

	public ValidateTaskException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public ValidateTaskException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ValidateTaskException(String arg0) {
		super(arg0);
		
	}

	public ValidateTaskException(Throwable arg0) {
		super(arg0);
		
	}
	
	

}
