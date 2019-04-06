package es.asb.taskapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="userapp")
public class UserEntity {

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="user_name")
	private String name;
	@Column(name="user_password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="creationdate")
	private Date creationdate;
	@Column(name="lastupdate")
	private Date lastupdate;
	
	
	public UserEntity() {
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getCreationdate() {
		return creationdate;
	}


	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}


	public Date getLastupdate() {
		return lastupdate;
	}


	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", creationdate=" + creationdate + ", lastupdate=" + lastupdate + "]";
	}


	@PrePersist
	private void datecreation() {
		this.creationdate= new Date();
		this.lastupdate=new Date();
	}
	
	@PreUpdate
	private void updateDate() {
		this.lastupdate=new Date();
	}
	
	
	public void updatepassword (String passwordupdate) {
		this.password=passwordupdate;
	}
	
}
