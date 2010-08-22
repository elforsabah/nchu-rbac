package cn.nchu.rbac.dao;

import java.util.List;


import cn.nchu.rbac.po.Role;
import cn.nchu.rbac.util.Page;

@SuppressWarnings("unchecked")
public interface IRoleDao {

	/**
	 * �����ɫ��Ϣ
	 * @param role ������ɫ��Ϣ�Ķ���
	 * @return ����ɹ���Ľ�ɫ���󣨰������ɵ�ID�������治�ɹ��򷵻� null
	 */
	public Long save(Role role);
	
	/**
	 * ���½�ɫ��Ϣ
	 * @param role ������ɫ��Ϣ�Ķ���
	 * @return true -- ����ɹ�;  false -- ���治�ɹ�
	 */
	public Integer update(Role role);
	
	
	/**
	 * ɾ����ɫ��Ϣ��role ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param role ��ɫ����
	 * @return true -- ɾ���ɹ���false -- ɾ��ʧ��
	 */
	public Integer deleteById(Role role);
	
	/**
	 * ��ѯ���������Ľ�ɫ�б�role Ϊ null �򷵻����н�ɫ
	 * @param role ������ѯ�����Ľ�ɫ����name Ϊģ����ѯ
	 * @return ����
	 */
	public List<Role> list(Role role);
	
	/**
	 * ����ѯ������ѯ��ҳ��Ľ�ɫ��Ϣ
	 * @param page ��ѯ��������ҳ��Ϣ����
	 * @return ��ҳ��Ĳ�ѯ��Ϣ
	 */
	
	public List findByPage(Page page);
	
	/**
	 * �õ���ҳ��¼������
	 * @param page ��ҳ����
	 * @return ����������Ȩ�޶��������
	 */
	public int findByCount(Page page); 
}
