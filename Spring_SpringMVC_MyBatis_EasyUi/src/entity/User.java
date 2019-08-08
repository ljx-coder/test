package entity;

public class User {
	private Integer uid;
	private String username;
	private String userpwd;

	public User() {
		super();
	}

	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	public User(Integer uid, String username, String userpwd) {
		super();
		this.uid = uid;
		this.username = username;
		this.userpwd = userpwd;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

}
