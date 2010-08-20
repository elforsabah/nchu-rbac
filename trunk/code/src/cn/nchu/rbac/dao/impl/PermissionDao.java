package cn.nchu.rbac.dao.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.IPermissionDao;
import cn.nchu.rbac.po.Permission;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class PermissionDao extends SqlMapClientDaoSupport implements IPermissionDao {

	@Override
	public Integer delete(Permission perm) {
		long permId=perm.getId();
		return getSqlMapClientTemplate().delete("Perm.deleteById", permId);
	}

	@Override
	public Permission findByCond(Permission cond) {
		
		return (Permission) getSqlMapClientTemplate().queryForList("Perm.findByCond",cond);
	}

	@Override
	public List findByPage(Page page) {
		
		return getSqlMapClientTemplate().queryForList("Perm.findByPage", page);
	}


	@Override
	public List<Permission> list(Permission perm) {
		
		return getSqlMapClientTemplate().queryForList("Perm.findBySelect",perm);
	}

	@Override
	public Permission save(Permission perm) {
		
		return (Permission) getSqlMapClientTemplate().insert("Perm.save", perm);
	}

	@Override
	public Integer update(Permission perm) {
		
		return getSqlMapClientTemplate().update("Perm.update", perm);
	}

}
