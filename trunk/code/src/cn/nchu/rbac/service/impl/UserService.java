package cn.nchu.rbac.service.impl;

import java.util.List;

import cn.nchu.rbac.dao.impl.UserDao;
import cn.nchu.rbac.po.User;
import cn.nchu.rbac.service.IUserService;
import cn.nchu.rbac.util.Page;
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
	public List<User> findByExample(User user) {
		return userDao.findByExample(user);
	}

	@Override
	public Page findByPage(Page page) {
		page.setRoot(userDao.findByPage(page));
		page.setTotalProperty(userDao.findByCount(page));
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
	public Long save(User user) {
		
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

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int findByCount(Page page) {
		return userDao.findByCount(page);
	}

	@Override
	public boolean resetPassword(User user) {
		System.out.println("---------------in service ");
		Integer flag = null;
		try {
		userDao.resetPassword(user.getId());
		} catch (Exception e ) {
			e.printStackTrace();
		}
		if (flag != null) {
			return true;
		} else {
			return false;
		}
	}

}
