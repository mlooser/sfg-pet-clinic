package com.example.ml.sfgpetclinic.config;

public class PetClinicDataSource {
	
	private String user;	
	private String password;	
	private String dburl;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDburl() {
		return dburl;
	}
	public void setDburl(String dburl) {
		this.dburl = dburl;
	}
	@Override
	public String toString() {
		return "DataSource [user=" + user + ", password=" + password + ", dburl=" + dburl + "]";
	}
	
	
}
