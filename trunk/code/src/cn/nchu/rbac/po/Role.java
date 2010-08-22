package cn.nchu.rbac.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Role implements Serializable {

	/* ��ɫ��� */
	private long id = 0;

	/* ��ɫ�� */
	private String roleName = null;

	/* ��ɫ�������� */
	private Date createTime = null;


	/* ��ɫ״̬ 0 �C ��Ч��1 �C ɾ����2 �C ��ʱͣ�� */
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
