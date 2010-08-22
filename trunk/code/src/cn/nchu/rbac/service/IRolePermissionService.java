package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.RolePermission;

public interface IRolePermissionService {

	/**
	 * 为某个角色添加一条权限
	 * @param rolePerm 角色权限信息
	 * @return 插入成功返回ID
	 */
	public Long save(RolePermission rolePerm);
	
	/**
	 * 删除一条角色权限
	 * @param rolePerm 角色权限
	 * @return true -- 删除成功 , false -- 删除失败
	 */
	public boolean delete(RolePermission rolePerm);
	
	/**
	 * 查找某个角色的所有权限
	 * @param roleId 角色ID
	 * @return 该角色的所有有效权限
	 */
	public List<RolePermission> findAll(Long roleId); 
	
	
	/**
	 * 得到记录的数量
	 * @param page
	 * @return
	 */
	public Integer findByCount(Long roleId);
	
	
}
