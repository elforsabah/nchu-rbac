package cn.nchu.rbac.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.nchu.rbac.dao.IRolePermissionDao;
import cn.nchu.rbac.po.RolePermission;

public class RolePermissionDao extends SqlMapClientDaoSupport implements IRolePermissionDao {

	@Override
	public boolean delete(RolePermission rolePerm) {
		
		Integer result = getSqlMapClientTemplate().delete("RolePermission.deleteById", rolePerm.getId());
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolePermission> findAll(Long roleId) {
		List list = getSqlMapClientTemplate().queryForList("RolePermission.findPermByRole", roleId);
		
		return list;
	}

	@Override
	public Long save(RolePermission rolePerm) {
		try {
		return (Long) getSqlMapClientTemplate().insert("RolePermission.save", rolePerm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int findByCount(Long roleId) {
		
		return (Integer) getSqlMapClientTemplate().queryForObject("RolePermission.findByCount", roleId);
	}
	
	

}
