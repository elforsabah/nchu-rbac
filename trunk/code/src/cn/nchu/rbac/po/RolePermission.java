package cn.nchu.rbac.po;

public class RolePermission {

	/* �ڲ���� */
	private long id = 0;

	/* ��ɫ��� */
	private long roleId = 0;

	/* Ȩ�ޱ�� */
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
