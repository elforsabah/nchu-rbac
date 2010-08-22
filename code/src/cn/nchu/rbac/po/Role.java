package cn.nchu.rbac.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Role implements Serializable {

	/* 角色编号 */
	private long id = 0;

	/* 角色名 */
	private String roleName = null;

	/* 角色创建日期 */
	private Date createTime = null;


	/* 角色状态 0 – 有效，1 – 删除，2 – 暂时停用 */
	private int isValid = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getIsvalid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
