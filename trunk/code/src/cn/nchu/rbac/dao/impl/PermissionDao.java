package cn.nchu.rbac.dao.impl;

import java.util.List;

import cn.nchu.rbac.dao.IPermissionDao;
import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.util.Page;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class PermissionDao extends SqlMapClientDaoSupport implements IPermissionDao {

	@Override
	public Integer delete(Permission perm) {
		long permId=perm.getId();
		return getSqlMapClientTemplate().delete("Perm.deleteById", permId);
	}

	public int findByCount(Page page) {
		return (Integer) getSqlMapClientTemplate().queryForObject("Perm.findByCount", page);
	}


	@Override
	public List findByPage(Page page) {
		List list = getSqlMapClientTemplate().queryForList("Perm.findByPage", page);
		return list;
	}


	@Override
	public List<Permission> list(Permission perm) {
		
		return getSqlMapClientTemplate().queryForList("Perm.findBySelect",perm);
	}

	@Override
	public Long save(Permission perm) {
		
		return (Long) getSqlMapClientTemplate().insert("Perm.save", perm);
	}

	@Override
	public Integer update(Permission perm) {
		try {
		return getSqlMapClientTemplate().update("Perm.update", perm);
		} catch (Exception e ) {e.printStackTrace();}
		return null;
	}

}
