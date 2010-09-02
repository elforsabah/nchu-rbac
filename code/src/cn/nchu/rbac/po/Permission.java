package cn.nchu.rbac.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Permission implements Serializable {

	/* 权限编号 */
	private long id = 0;

	/* 权限名 */
	private String permName = null;
	
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
