package com.example.dto;

public class temp 
{
	private int userid;
	private int candidateid;
	
	
	
	public temp() {
		super();
	}
	public temp(int userid, int candidateid) {
		super();
		this.userid = userid;
		this.candidateid = candidateid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCandidateid() {
		return candidateid;
	}
	public void setCandidateid(int candidateid) {
		this.candidateid = candidateid;
	}
	@Override
	public String toString() {
		return "temp [userid=" + userid + ", candidateid=" + candidateid + "]";
	}
	
	
	

}
