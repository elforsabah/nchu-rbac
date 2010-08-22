package cn.nchu.rbac.dao;

import java.util.List;


import cn.nchu.rbac.po.RolePermission;

public interface IRolePermissionDao {

	/**
	 * ɾ��һ����ɫȨ��
	 * @param rolePerm
	 * @return
	 */
	public boolean delete(RolePermission rolePerm);

	/**
	 * ����ĳ����ɫ������Ȩ��
	 * @param roleId
	 * @return
	 */
	public List<RolePermission> findAll(Long roleId);

	/**
	 * ����һ����ɫȨ��
	 * @param rolePerm
	 * @return
	 */
	public Long save(RolePermission rolePerm);
	
	
	/**
	 * �õ���¼������
	 * @param page
	 * @return
	 */
	public int findByCount(Long roleId);

}
