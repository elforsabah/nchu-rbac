package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.impl.PermissionDao;
import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.service.IPermissionService;

public class PermissionService implements IPermissionService {

	private PermissionDao permissionDao;
	@Override
	public boolean delete(Permission perm) {
		Integer flag = permissionDao.delete(perm);
		if (flag != null) {
			return true;
		}
		return false;
	}

	@Override
	public Permission findByCond(Permission cond) {
		return  permissionDao.findByCond(cond);
	}

	@Override
	public Page findByPage(Page page) {
		permissionDao.findByPage(page);
	    return page;
	}

	@Override
	public List<Permission> list(Permission perm) {
		
		return permissionDao.list(perm);
	}

	@Override
	public Permission save(Permission perm) {
		// TODO Auto-generated method stub
		return permissionDao.save(perm);
	}

	@Override
	public boolean update(Permission perm) {
		Integer flag = permissionDao.update(perm);
		if (flag != null) {
			return true;
		}
		return false;
	}

}
