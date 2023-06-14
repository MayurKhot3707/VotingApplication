package com.example.entity;





import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class user {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String username;
   	private String password; 
    private String email;
    private String mobilenumber;
    private String role;
    
    @Column(nullable=true)
    private Integer candidateid;
    
    
    

	public int getUserid() {
		return userid;
	}




	public void setUserid(int userid) {
		this.userid = userid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
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




	public String getMobilenumber() {
		return mobilenumber;
	}




	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public Integer getCandidateid() {
		return candidateid;
	}




	public void setCandidateid(Integer candidateid) {
		this.candidateid = candidateid;
	}




	public user() {
		super();
	}




	public user(int userid, String username, String password, String email, String mobilenumber, String role,
			Integer candidateid) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.role = role;
		this.candidateid = candidateid;
	}




	@Override
	public String toString() {
		return "user [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobilenumber=" + mobilenumber + ", role=" + role + ", candidateid=" + candidateid + "]";
	}
    
    
    

	
    
    
	

		
    
	
}
