package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.dao.impl.UserDao;
import cn.nchu.rbac.po.User;
import cn.nchu.rbac.service.IUserService;
import cn.nchu.rbac.util.WebException;

public class UserService implements IUserService {

	private UserDao userDao;
	
	@Override
	public boolean delete(User user) throws WebException {
		long userId=user.getId();
		Integer flag = userDao.deleteById(userId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	@Override
	public User findByCond(User user) {
		// TODO Auto-generated method stub
		return (User) userDao.findByCond(user);
	}

	@Override
	public Page findByPage(Page page) {
		userDao.findByPage(page);
	    return page;
	}

	@Override
	public List<User> list(User user) {
		
		return userDao.list(user);
	}

	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}

	@Override
	public Object save(User user) {
		
		return userDao.save(user);
	}

	@Override
	public boolean update(User user) throws WebException {
		Integer flag = userDao.update(user);
		if (flag != null) {
			return true;
		}
		return false;
	}

}
