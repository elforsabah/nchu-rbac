package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.RolePermission;

public interface IRolePermissionService {

	/**
	 * Ϊĳ����ɫ���һ��Ȩ��
	 * @param rolePerm ��ɫȨ����Ϣ
	 * @return ����ɹ�����ID
	 */
	public Long save(RolePermission rolePerm);
	
	/**
	 * ɾ��һ����ɫȨ��
	 * @param rolePerm ��ɫȨ��
	 * @return true -- ɾ���ɹ� , false -- ɾ��ʧ��
	 */
	public boolean delete(RolePermission rolePerm);
	
	/**
	 * ����ĳ����ɫ������Ȩ��
	 * @param roleId ��ɫID
	 * @return �ý�ɫ��������ЧȨ��
	 */
	public List<RolePermission> findAll(Long roleId); 
	
	
	/**
	 * �õ���¼������
	 * @param page
	 * @return
	 */
	public Integer findByCount(Long roleId);
	
	
}
