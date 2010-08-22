package cn.nchu.rbac.dao.impl;

import java.util.List;

import cn.nchu.rbac.dao.IUserDao;
import cn.nchu.rbac.po.User;
import cn.nchu.rbac.util.Page;
import cn.nchu.rbac.util.WebException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("unchecked")
public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

	@Override
	public Integer deleteById(long userId) throws WebException {
		
		return getSqlMapClientTemplate().delete("User.deleteById", userId);
	}
	

   @Override
	public List<User> findByExample(User user) {
		
		return getSqlMapClientTemplate().queryForList("MyUser.findByExample",user);
	}
   
   
   public int findByCount(Page page) {

	    return (Integer) getSqlMapClientTemplate().queryForObject("MyUser.findByCount", page);
   }

	@Override
	public List findByPage(Page page) {
	
		return getSqlMapClientTemplate().queryForList("MyUser.findByPage", page);
	}

	@Override
	public List<User> list(User user) {
		
		return getSqlMapClientTemplate().queryForList("MyUser.findBySelect",user);
	}

	@Override
	public User login(User user) {
		
		return (User) getSqlMapClientTemplate().queryForObject("MyUser.login",user);
	}

	@Override
	public Long save(User user) {
		
		return (Long) getSqlMapClientTemplate().insert("MyUser.save", user);

	}

	@Override
	public Integer update(User user) throws WebException {
		
		return getSqlMapClientTemplate().update("MyUser.update", user);
	}
	
	public Integer resetPassword(long id) {
		Integer flag = null;
		try {
		System.out.println("-------------------- in dao ");
		flag = getSqlMapClientTemplate().update("MyUser.resetPassword", id);
		System.out.println("------------------- " + flag);
		} catch (Exception e) { e.printStackTrace(); }
		return flag;
	}

	

	

}
