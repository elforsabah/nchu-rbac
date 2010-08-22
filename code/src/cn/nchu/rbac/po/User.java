package cn.nchu.rbac.po;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {

	/* �û���� */
	private long id = 0;

	/* �û��� */
	private String username = null;

	/* �û����� */
	private String password = null;

	/* �û��������� */
	private Date createTime = null;
	
	/* �û�״̬ 0 �C ��Ч��1 �C ɾ����2 �C ��ʱͣ�� */
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
