package cn.nchu.rbac.po;

import java.sql.Date;

public class Role {

	/* ��ɫ��� */
	private long id = 0;

	/* ��ɫ�� */
	private String role_name = null;

	/* ��ɫ�������� */
	private Date create_time = null;

	/* ��ɫ״̬ 0 �C ��Ч��1 �C ɾ����2 �C ��ʱͣ�� */
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
