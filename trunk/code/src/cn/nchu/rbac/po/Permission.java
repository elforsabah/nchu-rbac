package cn.nchu.rbac.po;

public class Permission {

	/* Ȩ�ޱ�� */
	private long id = 0;

	/* Ȩ���� */
	private String perm_name = null;

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

	public String getPerm_name() {
		return perm_name;
	}

	public void setPerm_name(String permName) {
		perm_name = permName;
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
