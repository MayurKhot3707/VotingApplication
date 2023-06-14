package com.example.dto;
import com.example.entity.user;

public class loginResponse
{
	  private boolean success;
	    private user user;
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public user getUser() {
			return user;
		}
		public void setUser(user user) {
			this.user = user;
		}
		public loginResponse(boolean success, user user) {
			super();
			this.success = success;
			this.user = user;
		}
		public loginResponse() {
			super();
		}

}
