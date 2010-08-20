package cn.nchu.rbac.po;

import java.sql.Date;

public class Role {

	/* 角色编号 */
	private long id = 0;

	/* 角色名 */
	private String role_name = null;

	/* 角色创建日期 */
	private Date create_time = null;

	/* 角色状态 0 – 有效，1 – 删除，2 – 暂时停用 */
	private int isvalid = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date createTime) {
		create_time = createTime;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

}
