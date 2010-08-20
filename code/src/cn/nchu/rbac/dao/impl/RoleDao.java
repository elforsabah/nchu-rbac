package cn.nchu.rbac.dao.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.IRoleDao;
import cn.nchu.rbac.po.Role;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class RoleDao extends SqlMapClientDaoSupport implements IRoleDao {

	@Override
	public Integer deleteById( Role role) {
		
	   long userId=role.getId();
		return getSqlMapClientTemplate().delete("Role.deleteById", userId);
	}

	@Override
	public Role findByCond(Role cond) {
		
		return (Role) getSqlMapClientTemplate().queryForList("Role.findByCond",cond);
	}

	
	@Override
	public List findByPage(Page page) {
	
		return getSqlMapClientTemplate().queryForList("Role.findByPage", page);
	}

	@Override
	public List<Role> list(Role role) {
		
		return getSqlMapClientTemplate().queryForList("Role.findBySelect",role);
	}

	@Override
	public Role save(Role role) {
		
		return (Role) getSqlMapClientTemplate().insert("Role.save", role);

	}

	@Override
	public Integer update(Role role) {
		
		return getSqlMapClientTemplate().update("Role.update", role);
	}

}
