package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.po.Role;

public interface IRoleService {
	
	/**
	 * 保存角色信息
	 * @param role 包含角色信息的对象
	 * @return 保存成功后的角色对象（包含生成的ID），保存不成功则返回 null
	 */
	public Role save(Role role);
	
	
	/**
	 * 更新角色信息
	 * @param role 包含角色信息的对象
	 * @return true -- 保存成功;  false -- 保存不成功
	 */
	public boolean update(Role role);
	
	
	/**
	 * 删除角色信息，role 对象只需要包含 id 即可，删除时只用 id 删除
	 * @param role 角色对象
	 * @return true -- 删除成功；false -- 删除失败
	 */
	public boolean delete(Role role);
	
	
	/**
	 * 查询满足条件的角色列表，role 为 null 则返回所有角色
	 * @param role 包含查询条件的角色对象，name 为模糊查询
	 * @return 满足
	 */
	public List<Role> list(Role role);
	
	
	/**
	 * 按查询条件查询分页后的角色信息
	 * @param page 查询条件及分页信息对象
	 * @return 分页后的查询信息
	 */
	public Page findByPage(Page page);
	
	
	/**
	 * 按条件查找角色对象，多个条件则要求同时满足
	 * @param role 包含查询条件的角色对象
	 * @return 符合条件的角色对象，没有符合条件则返回 null
	 */
	public Role findByCond(Role cond); 
}
