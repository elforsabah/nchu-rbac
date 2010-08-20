package cn.nchu.rbac.po;

public class Permission {

	/* 权限编号 */
	private long id = 0;

	/* 权限名 */
	private String perm_name = null;

	/* 操作地址 */
	private String url = null;

	/* 权限状态 0 – 有效，1 – 删除，2 – 暂时停用 */
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
