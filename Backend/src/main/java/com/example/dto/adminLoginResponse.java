package com.example.dto;

import com.example.entity.admin;

public class adminLoginResponse 
{
	 private boolean success;
	    private admin admin;
	    
	    
	    public admin getAdmin() {
			return admin;
		}


		public void setAdmin(admin admin) {
			this.admin = admin;
		}


		public void setSuccess(boolean success) {
			this.success = success;
		}


		public adminLoginResponse() {
			super();
		}


		public adminLoginResponse(boolean success, com.example.entity.admin admin) {
			super();
			this.success = success;
			this.admin = admin;
		}


		public boolean isSuccess() {
			return success;
		}
	    
	    

}
