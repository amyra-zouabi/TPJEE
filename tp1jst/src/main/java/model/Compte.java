package model;

public class Compte {
private int id;
private String user;
private String mp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getMp() {
	return mp;
}
public void setMp(String mp) {
	this.mp = mp;
}
public Compte(int id, String user, String mp) {
	super();
	this.id = id;
	this.user = user;
	this.mp = mp;
}
public Compte() {
	super();
}

}
