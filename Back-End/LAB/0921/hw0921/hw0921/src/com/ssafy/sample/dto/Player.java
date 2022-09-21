package com.ssafy.sample.dto;

public class Player {
	private int pid;
	private String name;
	private int backnumber;
	private String team;
	
	public Player() {}

	public Player(String name, int backnumber, String team) {
		this.name = name;
		this.backnumber = backnumber;
		this.team = team;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBacknumber() {
		return backnumber;
	}

	public void setBacknumber(int backnumber) {
		this.backnumber = backnumber;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
}
