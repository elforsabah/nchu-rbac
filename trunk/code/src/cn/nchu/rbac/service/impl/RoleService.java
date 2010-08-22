package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.dao.impl.RoleDao;
import cn.nchu.rbac.po.Role;
import cn.nchu.rbac.service.IRoleService;
import cn.nchu.rbac.util.Page;

public class RoleService implements IRoleService {

	private RoleDao roleDao;
	@Override
	public boolean delete(Role role) {
		Integer flag = roleDao.deleteById(role);
		if (flag != null) {
			return true;
		}
		return false;
	}

	@Override
	public int findByCount(Page page) {
		
		return  roleDao.findByCount(page);
	}

	@Override
	public Page findByPage(Page page) {
		
		page.setRoot(roleDao.findByPage(page));
		page.setTotalProperty(roleDao.findByCount(page));
	    return page;
	}

	@Override
	public List<Role> list(Role role) {
		
		return roleDao.list(role);
	}

	@Override
	public Long save(Role role) {
		
		return roleDao.save(role);
		
	}

	@Override
	public boolean update(Role role) {
		
		Integer flag = roleDao.update(role);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
