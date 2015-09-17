package model;

public class User {
	public String login;
	public String password;
	
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}
}
