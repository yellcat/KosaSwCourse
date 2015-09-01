package JavaProject.dao;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String mobile;
	private String address;
	
	public Member(){};
	public Member(String id, String password, String name, String mobile, String address){
		this.id = id;
		this.name = name;
		this.pw = password;
		this.mobile = mobile;
		this.address = address;
	};
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}