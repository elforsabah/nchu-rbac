package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.User;
import cn.nchu.rbac.util.Page;
import cn.nchu.rbac.util.WebException;

public interface IUserService {
	
	/**
	 * 保存用户
	 * @param user	用户对象
	 * @return 保存后的用户对象（包含生成的ID），如果保存失败则返回 null
	 */
	public Long save(User user);
	
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return true -- 更新成功 ,  false -- 更新失败
	 * @throws WebException 函数内发生异常则抛出自定义异常
	 */
	public boolean update(User user) throws WebException;
	
	
	/**
	 * 删除用户信息，user 对象只需要包含 id 即可，删除时只用 id 删除
	 * @param user	用户对象
	 * @return	true -- 删除成功, false -- 删除失败
	 * @throws WebException	函数内发生异常则抛出自定义异常
	 */
	public boolean delete(User user) throws WebException;
	
	
	/**
	 * 用户登录，根据用户名和密码判断用户能否成功登录
	 * @param user	包含用户名和密码的user对象
	 * @return	登录成功后的用户对象，登录不成功返回 null
	 */
	public User login(User user); 
	
	
	/**
	 * 查询符合条件的用户列表，如果 user 为 null，则返回所有用户信息
	 * @param user
	 * @return 满足条件的用户列表，如果没有满足条件的用户，则返回长度为 0 的List
	 */
	public List<User> list(User user);
	
	/**
	 * 根据条件查找分页后的数据
	 * @param page
	 * @return
	 */
	public Page findByPage(Page page);
	
	
	/**
	 * 得到满足条件的用户数量
	 * @param page 分页对象
	 * @return 数量
	 */
	public int findByCount(Page page);
	
	
	/**
	 * 根据条件查找用户，多个条件则要求同时满足
	 * @param user 包含查找条件的 user 对象
	 * @return 返回满足条件的第一个 user 对象，如果没有符合条件就返回 null
	 */
	public List<User> findByExample(User user);

	
	/**
	 * 重置用户密码
	 * @param user	用户对象
	 * @return true -- 重置成功，false -- 重置失败
	 */
	public boolean resetPassword(User user);
	
	
}
