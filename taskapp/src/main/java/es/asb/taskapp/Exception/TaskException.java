package es.asb.taskapp.Exception;

public class TaskException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public TaskException() {
		super();
		//
	}

	public TaskException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public TaskException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public TaskException(String arg0) {
		super(arg0);
	
	}

	public TaskException(Throwable arg0) {
		super(arg0);
		
	}

	
	
}
