package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.util.Page;

public interface IPermissionService {

	/**
	 * ����Ȩ�޶���
	 * @param perm ����Ȩ����Ϣ��Ȩ�޶���
	 * @return ������Ȩ��ID
	 */
	public Long save(Permission perm);
	
	
	/**
	 * ����Ȩ����Ϣ
	 * @param perm ����Ȩ����Ϣ�Ķ���
	 * @return true -- ����ɹ�;  false -- ���治�ɹ�
	 */
	public boolean update(Permission perm);
	
	
	/**
	 * ɾ��Ȩ����Ϣ��perm ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param perm Ȩ�޶���
	 * @return true -- ɾ���ɹ���false -- ɾ��ʧ��
	 */
	public boolean delete(Permission perm);
	
	
	/**
	 * ��ѯ����������Ȩ���б�perm Ϊ null �򷵻�����Ȩ��
	 * @param perm ������ѯ������Ȩ�޶���name Ϊģ����ѯ
	 * @return ����
	 */
	public List<Permission> list(Permission perm);
	
	
	/**
	 * ����ѯ������ѯ��ҳ���Ȩ����Ϣ
	 * @param page ��ѯ��������ҳ��Ϣ����
	 * @return ��ҳ���Ȩ����Ϣ
	 */
	public Page findByPage(Page page);
	
	
	/**
	 * ����������Ȩ�޶��������
	 * @param page ��ҳ����
	 * @return ����������Ȩ�޶��������
	 */
	public int findByCount(Page page); 
}
