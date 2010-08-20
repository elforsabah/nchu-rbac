package cn.nchu.rbac.po;

import java.sql.Date;

public class User {

	/* 用户编号 */
	private long id = 0;

	/* 用户名 */
	private String username = null;

	/* 用户密码 */
	private String password = null;

	/* 用户创建日期 */
	private Date create_time = null;

	/* 用户状态 0 – 有效，1 – 删除，2 – 暂时停用 */
	private int isvalid = 0;

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date createTime) {
		create_time = createTime;
	}

}
