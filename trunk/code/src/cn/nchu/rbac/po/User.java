package cn.nchu.rbac.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {

	/* 用户编号 */
	private long id = 0;

	/* 用户名 */
	private String username = null;

	/* 用户密码 */
	private String password = null;

	/* 用户创建日期 */
	private Date createTime = null;
	
	/* 用户状态 0 – 有效，1 – 删除，2 – 暂时停用 */
	private int isValid = 0;

	public int getIsValid() {
		return isValid;
	}

	public void setIsvalid(int isValid) {
		this.isValid = isValid;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreate_time(Date createTime) {
		this.createTime = createTime;
	}

}
