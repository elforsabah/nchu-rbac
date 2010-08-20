package cn.nchu.rbac.po;

public class UserRole {

	/* 内部编号 */
	private long id = 0;

	/* 用户编号 */
	private long userId = 0;

	/* 角色编号 */
	private long roleId = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	

}
