package cn.nchu.rbac.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Permission implements Serializable {

	/* Ȩ�ޱ�� */
	private long id = 0;

	/* Ȩ���� */
	private String permName = null;
	
	/* ������ַ */
	private String url = null;

	/* Ȩ��״̬ 0 �C ��Ч��1 �C ɾ����2 �C ��ʱͣ�� */
	private int isvalid = 0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

}
