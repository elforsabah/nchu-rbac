package cn.nchu.rbac.service.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import cn.nchu.rbac.dao.IUserDao;
import cn.nchu.rbac.dao.impl.UserDao;
import cn.nchu.rbac.po.User;
import cn.nchu.rbac.service.IUserService;
import cn.nchu.rbac.service.impl.UserService;
import cn.nchu.rbac.util.WebException;

public class IUserServiceTest {

	@Test
	public void testDelete() {
		IUserDao userDao = new UserDao();
		IUserService userService = new UserService();
		
		
	}

	@Test
	public void testFindByCond() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
