package cn.nchu.rbac.dao;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.po.Permission;

@SuppressWarnings("unchecked")
public interface IPermissionDao {

	/**
	 * ����Ȩ�޶���
	 * @param perm ����Ȩ����Ϣ��Ȩ�޶���
	 * @return ������Ȩ�޶��󣨰������ɵ�ID�������治�ɹ��򷵻� null
	 */
	public Permission save(Permission perm);
	
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
	 * ����������Ȩ�޶��󣬶��������Ҫ��ͬʱ����
	 * @param perm ������ѯ������Ȩ�޶���
	 * @return ����������Ȩ�޶���û�з��������򷵻� null
	 */
	public Permission findByCond(Permission cond); 
	
}
