package cn.nchu.rbac.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RolePermission implements Serializable {

	private Long id  = null;
	
	private Long roleId = null;
	
	private Long permId = null;
	
	private String permName = null;
	
	private String url = null;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermId() {
		return permId;
	}

	public void setPermId(Long permId) {
		this.permId = permId;
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
	
	
}
