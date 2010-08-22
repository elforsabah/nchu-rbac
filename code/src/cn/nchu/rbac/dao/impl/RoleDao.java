package cn.nchu.rbac.dao.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import cn.nchu.rbac.dao.IRoleDao;
import cn.nchu.rbac.po.Role;
import cn.nchu.rbac.util.Page;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class RoleDao extends SqlMapClientDaoSupport implements IRoleDao {

	@Override
	public Integer deleteById( Role role) {
		
	   long userId=role.getId();
		return getSqlMapClientTemplate().delete("Role.deleteById", userId);
	}

	public int findByCount(Page page) {
		
		return (Integer) getSqlMapClientTemplate().queryForObject("Role.findByCount",page);
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
	public Long save(Role role) {
		try {
		role.setCreateTime(new Date(Calendar.getInstance().getTimeInMillis()));
		return (Long) getSqlMapClientTemplate().insert("Role.save", role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Integer update(Role role) {
		try {
		return getSqlMapClientTemplate().update("Role.update", role);
		} catch (Exception e) {e.printStackTrace();}return null;	}
	

}
