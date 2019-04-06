package es.asb.taskapp.api;

public class User {

	private Long id;
	private String name;
	private String email;
	private String password;
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void passwordcreate() {
		String upperletter="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallletter=upperletter.toLowerCase();	
		String number="0123456789";
		String passwordgenerated="";
		int obtain;
		for(int i=0;i<=7;i++) {
			int option=(int) (Math.random() * 3)+1;
			if(option==1) {
				obtain=(int) (Math.random() * 26);
				passwordgenerated=passwordgenerated+upperletter.substring(obtain,obtain+1 );
			}else if(option==2) {
				obtain=(int) (Math.random() * 26);
				passwordgenerated=passwordgenerated+smallletter.substring(obtain,obtain+1 );
			}else {
				obtain=(int) (Math.random() * 10);
				passwordgenerated=passwordgenerated+number.substring(obtain,obtain+1 );
			}
		}
		this.password=passwordgenerated;
	}
	
	
}
