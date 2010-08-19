package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.base.Page;
import cn.nchu.rbac.po.Role;

public interface IRoleService {
	
	/**
	 * �����ɫ��Ϣ
	 * @param role ������ɫ��Ϣ�Ķ���
	 * @return ����ɹ���Ľ�ɫ���󣨰������ɵ�ID�������治�ɹ��򷵻� null
	 */
	public Role save(Role role);
	
	
	/**
	 * ���½�ɫ��Ϣ
	 * @param role ������ɫ��Ϣ�Ķ���
	 * @return true -- ����ɹ�;  false -- ���治�ɹ�
	 */
	public boolean update(Role role);
	
	
	/**
	 * ɾ����ɫ��Ϣ��role ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param role ��ɫ����
	 * @return true -- ɾ���ɹ���false -- ɾ��ʧ��
	 */
	public boolean delete(Role role);
	
	
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
	public Page findByPage(Page page);
	
	
	/**
	 * ���������ҽ�ɫ���󣬶��������Ҫ��ͬʱ����
	 * @param role ������ѯ�����Ľ�ɫ����
	 * @return ���������Ľ�ɫ����û�з��������򷵻� null
	 */
	public Role findByCond(Role cond); 
}
