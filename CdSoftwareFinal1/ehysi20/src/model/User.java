package model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -5083759422249745403L;
	protected String user;
    protected  String pass;
	
	protected int level;//1-Cashier, 2-Manager, 3-Admin
	
	public User() {
		this("","",3);
	}
	public User( String user, String pass, int level) {
		super();

		
		this.user = user;
		this.pass = pass;
		this.level = level;
	}
	
	
	
	public  String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String toString(){
		return "User: "+this.getUser()+
				"\nPass: "+this.getPass()+"\nLevel: "+this.getLevel();
	}

}
