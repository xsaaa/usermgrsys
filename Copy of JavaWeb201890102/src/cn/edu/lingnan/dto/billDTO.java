package cn.edu.lingnan.dto;

public class billDTO {
	private String usersID;
	private String price;
	private String waID;
	private String flag;
	
	public String getUsersID() {
		return usersID;
	}
	public void setUsersID(String usersID) {
		this.usersID = usersID;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getWaID() {
		return waID;
	}
	public void setWaID(String waID) {
		this.waID = waID;
	}

}
