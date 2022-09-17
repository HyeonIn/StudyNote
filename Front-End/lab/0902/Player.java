package model;

public class Player {
	private int id;
	private String name;
	private int backnumber;
	private String team;
	
	public Player() {}

	public Player(int id, String name, int backnumber, String team) {
		super();
		this.id = id;
		this.name = name;
		this.backnumber = backnumber;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", backnumber=" + backnumber + ", team=" + team + "]";
	}
	
}
