package cn.nchu.rbac.dao.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.IUserDao;
import cn.nchu.rbac.po.User;
import cn.nchu.rbac.util.WebException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

	@Override
	public Integer deleteById(long userId) throws WebException {
		
		return getSqlMapClientTemplate().delete("User.deleteById", userId);
	}
	

   @Override
	public List<User> findByCond(User user) {
		
		return getSqlMapClientTemplate().queryForList("User.findByCond",user);
	}

	@Override
	public List findByPage(Page page) {
		
		return getSqlMapClientTemplate().queryForList("User.findByPage", page);
	}

	@Override
	public List<User> list(User user) {
		
		return getSqlMapClientTemplate().queryForList("User.findBySelect",user);
	}

	@Override
	public User login(User user) {
		
		return (User) getSqlMapClientTemplate().queryForObject("User.login",user);
	}

	@Override
	public Object save(User user) {
		
		return getSqlMapClientTemplate().insert("User.save", user);

	}

	@Override
	public Integer update(User user) throws WebException {
		
		return getSqlMapClientTemplate().update("User.update", user);
	}

	

	

}
