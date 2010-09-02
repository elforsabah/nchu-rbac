package cn.nchu.rbac.service;

import java.util.List;

import cn.nchu.rbac.po.User;
import cn.nchu.rbac.util.Page;
import cn.nchu.rbac.util.WebException;

public interface IUserService {
	
	/**
	 * �����û�
	 * @param user	�û�����
	 * @return �������û����󣨰������ɵ�ID�����������ʧ���򷵻� null
	 */
	public Long save(User user);
	
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return true -- ���³ɹ� ,  false -- ����ʧ��
	 * @throws WebException �����ڷ����쳣���׳��Զ����쳣
	 */
	public boolean update(User user) throws WebException;
	
	
	/**
	 * ɾ���û���Ϣ��user ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param user	�û�����
	 * @return	true -- ɾ���ɹ�, false -- ɾ��ʧ��
	 * @throws WebException	�����ڷ����쳣���׳��Զ����쳣
	 */
	public boolean delete(User user) throws WebException;
	
	
	/**
	 * �û���¼�������û����������ж��û��ܷ�ɹ���¼
	 * @param user	�����û����������user����
	 * @return	��¼�ɹ�����û����󣬵�¼���ɹ����� null
	 */
	public User login(User user); 
	
	
	/**
	 * ��ѯ�����������û��б���� user Ϊ null���򷵻������û���Ϣ
	 * @param user
	 * @return �����������û��б����û�������������û����򷵻س���Ϊ 0 ��List
	 */
	public List<User> list(User user);
	
	/**
	 * �����������ҷ�ҳ�������
	 * @param page
	 * @return
	 */
	public Page findByPage(Page page);
	
	
	/**
	 * �õ������������û�����
	 * @param page ��ҳ����
	 * @return ����
	 */
	public int findByCount(Page page);
	
	
	/**
	 * �������������û������������Ҫ��ͬʱ����
	 * @param user �������������� user ����
	 * @return �������������ĵ�һ�� user �������û�з��������ͷ��� null
	 */
	public List<User> findByExample(User user);

	
	/**
	 * �����û�����
	 * @param user	�û�����
	 * @return true -- ���óɹ���false -- ����ʧ��
	 */
	public boolean resetPassword(User user);
	
	
}
