package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.util.Page;

public interface IPermissionService {

	/**
	 * 保存权限对象
	 * @param perm 包含权限信息的权限对象
	 * @return 保存后的权限ID
	 */
	public Long save(Permission perm);
	
	
	/**
	 * 更新权限信息
	 * @param perm 包含权限信息的对象
	 * @return true -- 保存成功;  false -- 保存不成功
	 */
	public boolean update(Permission perm);
	
	
	/**
	 * 删除权限信息，perm 对象只需要包含 id 即可，删除时只用 id 删除
	 * @param perm 权限对象
	 * @return true -- 删除成功；false -- 删除失败
	 */
	public boolean delete(Permission perm);
	
	
	/**
	 * 查询满足条件的权限列表，perm 为 null 则返回所有权限
	 * @param perm 包含查询条件的权限对象，name 为模糊查询
	 * @return 满足
	 */
	public List<Permission> list(Permission perm);
	
	
	/**
	 * 按查询条件查询分页后的权限信息
	 * @param page 查询条件及分页信息对象
	 * @return 分页后的权限信息
	 */
	public Page findByPage(Page page);
	
	
	/**
	 * 按条件查找权限对象的数量
	 * @param page 分页对象
	 * @return 符合条件的权限对象的数量
	 */
	public int findByCount(Page page); 
}
