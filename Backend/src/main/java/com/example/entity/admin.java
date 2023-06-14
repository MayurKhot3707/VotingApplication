package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adid;
	private String adminName;
	private String password;
	private String roll;
	
	
	


	public admin() {
		super();
	}


	public admin(int adid, String adminName, String password, String roll) {
		super();
		this.adid = adid;
		this.adminName = adminName;
		this.password = password;
		this.roll = roll;
	}


	
	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	public int getAdid() {
		return adid;
	}


	public void setAdid(int adid) {
		this.adid = adid;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "admin [adid=" + adid + ", adminName=" + adminName + ", password=" + password + "]";
	}

	
	
}
