package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class candidate 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int canid;
	private String canname;
	private int votecount=0;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidateid", referencedColumnName="canid")
	private Set<user> user;
	
	
	
	
public int getVotecount() {
		return votecount;
	}
	public void setVotecount(int votecount) {
		this.votecount = votecount;
	}
	
	public int getCanid() {
		return canid;
	}
	public void setCanid(int canid) {
		this.canid = canid;
	}
	public String getCanname() {
		return canname;
	}
	public void setCanname(String canname) {
		this.canname = canname;
	}
	

	@Override
	public String toString() {
		return "candidate [canid=" + canid + ", canname=" + canname + ", user=" + user + "]";
	}
	
	
	
	

	
}
