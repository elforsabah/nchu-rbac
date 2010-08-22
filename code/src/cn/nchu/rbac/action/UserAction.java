package cn.nchu.rbac.action;

import java.util.ArrayList;
import java.util.List;


import cn.nchu.rbac.po.User;
import cn.nchu.rbac.service.IUserService;
import cn.nchu.rbac.util.BaseAction;
import cn.nchu.rbac.util.MyUtils;
import cn.nchu.rbac.util.Page;
import cn.nchu.rbac.util.WebException;

public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String SUCCESS_MANAGER = "success_manager";

	private IUserService userService;

	private User user;

	private boolean success;

	private Page page;

	private Long userId;

	private String userName;

	private String password;

	private boolean manager;

	private String tip;

	public String logout() {
		getSession().removeAttribute("user");
		success = true;
		return SUCCESS;
	}

	public String login() {
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		User _user = userService.login(user);

		if (_user != null) {
			this.setTip("manager");// 管理员
			getSession().setAttribute("user", _user);
			return SUCCESS;
		} else {
			this.setTip("用户名或者密码错误!");
			return INPUT;
		}
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public String save() {
		userId = userService.save(user);
		if (userId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	public String resetPassword() {
		String strUserId = getRequest().getParameter("id");
		if (strUserId != null && !"".equals(strUserId)) {
			User user = new User();
			user.setId(Integer.valueOf(strUserId));
			success = userService.resetPassword(user);
		}
		
		return SUCCESS;
	}

	/**
	 * 查找用户信息
	 * 
	 * @return
	 */
	public String findAllUser() {
		String strCondition = getRequest().getParameter("conditions");
		List<Object> conditions = new ArrayList<Object>();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = userService.findByPage(page);
		return SUCCESS;
	}

	public String findByExample() {
		page = new Page();
		page.setRoot(userService.findByExample(user));
		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws WebException 
	 */
	public String delete() throws WebException {
		String strUserId = getRequest().getParameter("id");
		if (strUserId != null && !"".equals(strUserId)) {
			User user = new User();
			user.setId(Integer.valueOf(strUserId));
			success = userService.delete(user);
		}
		return SUCCESS;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws WebException {
		String fieldName = getRequest().getParameter("fieldName");
		
		String fieldValue = getRequest().getParameter("fieldValue");
		String strUserId = getRequest().getParameter("userId");
		if (strUserId != null && !"".equals(strUserId)) {
			User user = new User();
			
			user.setId(Long.valueOf(userId));
			MyUtils.invokeSetMethod(fieldName, user, new Object[] { fieldValue });
			success = userService.update(user);
		}
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
