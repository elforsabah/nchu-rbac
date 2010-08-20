package cn.nchu.rbac.dao;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.po.Permission;

@SuppressWarnings("unchecked")
public interface IPermissionDao {

	/**
	 * 保存权限对象
	 * @param perm 包含权限信息的权限对象
	 * @return 保存后的权限对象（包含生成的ID），保存不成功则返回 null
	 */
	public Permission save(Permission perm);
	
	/**
	 * 更新权限信息
	 * @param perm 包含权限信息的对象
	 * @return true -- 保存成功;  false -- 保存不成功
	 */
	public Integer update(Permission perm);
	
	
	/**
	 * 删除权限信息，perm 对象只需要包含 id 即可，删除时只用 id 删除
	 * @param perm 权限对象
	 * @return true -- 删除成功；false -- 删除失败
	 */
	public Integer delete(Permission perm);
	
	
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
	
	public List findByPage(Page page);
	
	
	/**
	 * 按条件查找权限对象，多个条件则要求同时满足
	 * @param perm 包含查询条件的权限对象
	 * @return 符合条件的权限对象，没有符合条件则返回 null
	 */
	public Permission findByCond(Permission cond); 
	
}
