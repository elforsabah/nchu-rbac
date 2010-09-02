package cn.nchu.rbac.action;


import cn.nchu.rbac.po.RolePermission;
import cn.nchu.rbac.service.IRolePermissionService;
import cn.nchu.rbac.util.BaseAction;
import cn.nchu.rbac.util.Page;


@SuppressWarnings("serial")
public class RolePermissionAction extends BaseAction {

	private IRolePermissionService rolePermService;

	private RolePermission rolePerm;

	private boolean success;

	private Page page;

	private Long id;

	
	public String save() {

		id = rolePermService.save(rolePerm);

		if (id != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	public String delete() {
		String id = getRequest().getParameter("id");
		if (id != null && !"".equals(id)) {
			RolePermission rolePerm = new RolePermission();
			rolePerm.setId(Long.valueOf(id));
			success = rolePermService.delete(rolePerm);
		}
		return SUCCESS;
	}
	
	public String findAll() {
		String roleId = getRequest().getParameter("roleId");
		if (roleId != null && !"".equals(roleId)) {
			page = new Page();
			page.setRoot(rolePermService.findAll(Long.valueOf(roleId)));
			page.setTotalProperty(rolePermService.findByCount(Long.valueOf(roleId)));
			
		}
		return SUCCESS;
	}
	
	
	public IRolePermissionService getRolePermService() {
		return rolePermService;
	}

	public void setRolePermService(IRolePermissionService rolePermService) {
		this.rolePermService = rolePermService;
	}

	public RolePermission getRolePerm() {
		return rolePerm;
	}

	public void setRolePerm(RolePermission rolePerm) {
		this.rolePerm = rolePerm;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
