package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.impl.RoleDao;
import cn.nchu.rbac.po.Role;
import cn.nchu.rbac.service.IRoleService;

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
	public Role findByCond(Role cond) {
		
		return  roleDao.findByCond(cond);
	}

	@Override
	public Page findByPage(Page page) {
		
		roleDao.findByPage(page);
	    return page;
	}

	@Override
	public List<Role> list(Role role) {
		
		return roleDao.list(role);
	}

	@Override
	public Role save(Role role) {
		
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

}
