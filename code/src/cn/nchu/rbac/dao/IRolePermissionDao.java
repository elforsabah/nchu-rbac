package cn.nchu.rbac.dao;

import java.util.List;


import cn.nchu.rbac.po.RolePermission;

public interface IRolePermissionDao {

	/**
	 * 删除一个角色权限
	 * @param rolePerm
	 * @return
	 */
	public boolean delete(RolePermission rolePerm);

	/**
	 * 查找某个角色的所有权限
	 * @param roleId
	 * @return
	 */
	public List<RolePermission> findAll(Long roleId);

	/**
	 * 保存一个角色权限
	 * @param rolePerm
	 * @return
	 */
	public Long save(RolePermission rolePerm);
	
	
	/**
	 * 得到记录的数量
	 * @param page
	 * @return
	 */
	public int findByCount(Long roleId);

}
