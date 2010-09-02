package cn.nchu.rbac.action;

import java.util.ArrayList;
import java.util.List;

import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.service.IPermissionService;
import cn.nchu.rbac.util.BaseAction;
import cn.nchu.rbac.util.MyUtils;
import cn.nchu.rbac.util.Page;



@SuppressWarnings("serial")
public class PermissionAction extends BaseAction {
	
	private IPermissionService permService;

	private Permission perm;

	private boolean success;

	private Page page;

	private Long id;
	
	public String save() {
		perm.setIsvalid(1);	// 1 - status normal
		id = permService.save(perm);

		if (id != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	public String update() {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String id = getRequest().getParameter("id");
		if (id != null && !"".equals(id)) {
			Permission perm = new Permission();
			perm.setId(Integer.valueOf(id));
			MyUtils.invokeSetMethod(fieldName, perm, new Object[] { fieldValue });
			success = permService.update(perm);
		}
		return SUCCESS;
	}
	
	public String delete() {
		String id = getRequest().getParameter("id");
		if (id != null && !"".equals(id)) {
			Permission perm = new Permission();
			perm.setId(Integer.valueOf(id));
			success = permService.delete(perm);
		}
		return SUCCESS;
	}
	
	public String findAllPermission() {
		String strCondition = getRequest().getParameter("conditions");
		List<Object> conditions = new ArrayList<Object>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = permService.findByPage(page);
		return SUCCESS;
	}

	public IPermissionService getPermService() {
		return permService;
	}

	public void setPermService(IPermissionService permService) {
		this.permService = permService;
	}

	public Permission getPerm() {
		return perm;
	}

	public void setPerm(Permission perm) {
		this.perm = perm;
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
