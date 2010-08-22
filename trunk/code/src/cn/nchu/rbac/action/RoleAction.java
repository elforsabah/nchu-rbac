package cn.nchu.rbac.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.nchu.rbac.po.Role;
import cn.nchu.rbac.service.IRoleService;
import cn.nchu.rbac.util.BaseAction;
import cn.nchu.rbac.util.MyUtils;
import cn.nchu.rbac.util.Page;


public class RoleAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;

	private IRoleService roleService;

	private Role role;

	private boolean success;

	private Page page;

	private Long id;
	
	public String save() {
		role.setIsValid(1);	// 1 - status normal
		id = roleService.save(role);

		if (id != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	public String update() {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String id = getRequest().getParameter("id");
		try {
		if (id != null && !"".equals(id)) {
			Role role = new Role();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			role.setId(Integer.valueOf(id));
			Object[] values = null;
			if ("createTime".equals(fieldName)) {
				Date date = sdf.parse(fieldValue);
				if (date != null) {
					values = new Object[]{new java.sql.Date(date.getTime())};
				}
			} else {
				values = new Object[]{fieldValue};
			}
			MyUtils.invokeSetMethod(fieldName, role, values);
			success = roleService.update(role);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delete() {
		String id = getRequest().getParameter("id");
		if (id != null && !"".equals(id)) {
			Role role = new Role();
			role.setId(Integer.valueOf(id));
			success = roleService.delete(role);
		}
		return SUCCESS;
	}
	
	public String findAllRole() {
		String strCondition = getRequest().getParameter("conditions");
		List<Object> conditions = new ArrayList<Object>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = roleService.findByPage(page);
		return SUCCESS;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
