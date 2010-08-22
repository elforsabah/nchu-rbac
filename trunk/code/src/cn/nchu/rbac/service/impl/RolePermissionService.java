package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.dao.IRolePermissionDao;
import cn.nchu.rbac.po.RolePermission;
import cn.nchu.rbac.service.IRolePermissionService;

public class RolePermissionService implements IRolePermissionService {
	
	private IRolePermissionDao rolePermDao = null;

	@Override
	public boolean delete(RolePermission rolePerm) {

		return rolePermDao.delete(rolePerm);
	}

	@Override
	public List<RolePermission> findAll(Long roleId) {
		List<RolePermission> list = rolePermDao.findAll(roleId);
		
		return list;
	}

	@Override
	public Long save(RolePermission rolePerm) {
		
		return rolePermDao.save(rolePerm);
	}

	public IRolePermissionDao getRolePermDao() {
		return rolePermDao;
	}

	public void setRolePermDao(IRolePermissionDao rolePermDao) {
		this.rolePermDao = rolePermDao;
	}

	@Override
	public Integer findByCount(Long roleId) {
		
		return rolePermDao.findByCount(roleId);
	}

	
	
}
