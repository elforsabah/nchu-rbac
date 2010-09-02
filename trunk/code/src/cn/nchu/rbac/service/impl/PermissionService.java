package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.dao.impl.PermissionDao;
import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.service.IPermissionService;
import cn.nchu.rbac.util.Page;

public class PermissionService implements IPermissionService {

	private PermissionDao permDao;
	
	@Override
	public boolean delete(Permission perm) {
		Integer flag = permDao.delete(perm);
		if (flag != null) {
			return true;
		}
		return false;
	}


	public int findByCount(Page page) {
		return  permDao.findByCount(page);
	}

	@Override
	public Page findByPage(Page page) {
		page.setRoot(permDao.findByPage(page));
		page.setTotalProperty(permDao.findByCount(page));
	    return page;
	}

	@Override
	public List<Permission> list(Permission perm) {
		
		return permDao.list(perm);
	}

	@Override
	public Long save(Permission perm) {
		return permDao.save(perm);
	}

	@Override
	public boolean update(Permission perm) {
		Integer flag = permDao.update(perm);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public PermissionDao getPermDao() {
		return permDao;
	}

	public void setPermDao(PermissionDao permDao) {
		this.permDao = permDao;
	}

}
