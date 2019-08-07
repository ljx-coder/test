package demoApplication.entity;

public class User {

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", pwd=" + pwd + "]";
	}

	private Integer uid;
	private String name;
	private String pwd;

	public Integer getUid() {
		return uid;
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User(Integer uid, String name, String pwd) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
