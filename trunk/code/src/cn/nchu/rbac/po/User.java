package cn.nchu.rbac.po;

import java.sql.Date;

public class User {

	/* �û���� */
	private long id = 0;

	/* �û��� */
	private String username = null;

	/* �û����� */
	private String password = null;

	/* �û��������� */
	private Date create_time = null;

	/* �û�״̬ 0 �C ��Ч��1 �C ɾ����2 �C ��ʱͣ�� */
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
