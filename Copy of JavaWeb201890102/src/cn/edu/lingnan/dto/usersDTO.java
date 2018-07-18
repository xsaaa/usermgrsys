package cn.edu.lingnan.dto;

public class usersDTO {
	private String usersID;
	private String usersName;
	private String superUsers;
	private String password;
	private String flag;
	
	public String getUsersID() {
		return usersID;
	}
	public void setUsersID(String usersID) {
		this.usersID = usersID;
	}

	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	
	public String getSuperUsers() {
		return superUsers;
	}
	public void setSuperUsers(String superUsers) {
		this.superUsers = superUsers;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
