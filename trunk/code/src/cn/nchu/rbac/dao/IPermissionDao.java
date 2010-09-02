package cn.nchu.rbac.dao;

import java.util.List;


import cn.nchu.rbac.po.Permission;
import cn.nchu.rbac.util.Page;

@SuppressWarnings("unchecked")
public interface IPermissionDao {

	/**
	 * ����Ȩ�޶���
	 * @param perm ����Ȩ����Ϣ��Ȩ�޶���
	 * @return ������Ȩ��ID�����治�ɹ��򷵻� null
	 */
	public Long save(Permission perm);
	
	/**
	 * ����Ȩ����Ϣ
	 * @param perm ����Ȩ����Ϣ�Ķ���
	 * @return true -- ����ɹ�;  false -- ���治�ɹ�
	 */
	public Integer update(Permission perm);
	
	
	/**
	 * ɾ��Ȩ����Ϣ��perm ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param perm Ȩ�޶���
	 * @return true -- ɾ���ɹ���false -- ɾ��ʧ��
	 */
	public Integer delete(Permission perm);
	
	
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
	
	public List findByPage(Page page);
	
	
	/**
	 * �õ���ҳ��¼������
	 * @param page ��ҳ����
	 * @return ����������Ȩ�޶��������
	 */
	public int findByCount(Page page); 
	
}
