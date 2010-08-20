package cn.nchu.rbac.po;

public class RolePermission {

	/* 内部编号 */
	private long id = 0;

	/* 角色编号 */
	private long roleId = 0;

	/* 权限编号 */
	private long permId = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getPermId() {
		return permId;
	}

	public void setPermId(long permId) {
		this.permId = permId;
	}

	

}
