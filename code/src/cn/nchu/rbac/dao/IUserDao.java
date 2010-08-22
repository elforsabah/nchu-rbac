package cn.nchu.rbac.dao;

import java.util.List;


import cn.nchu.rbac.po.User;
import cn.nchu.rbac.util.Page;
import cn.nchu.rbac.util.WebException;

public interface IUserDao {

	/**
	 * �����û�
	 * @param user	�û�����
	 * @return �������û����󣨰������ɵ�ID�����������ʧ���򷵻� null
	 */
	public Object save(User user);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return 
	 * @throws WebException �����ڷ����쳣���׳��Զ����쳣
	 */
	public Integer update(User user) throws WebException;
	
	/**
	 * ɾ���û���Ϣ��user ����ֻ��Ҫ���� id ���ɣ�ɾ��ʱֻ�� id ɾ��
	 * @param user	�û�����
	 * @return	true -- ɾ���ɹ�, false -- ɾ��ʧ��
	 * @throws WebException	�����ڷ����쳣���׳��Զ����쳣
	 */
	public Integer deleteById(long userId) throws WebException;
	
	
	
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
	 * �õ������������û�����
	 * @param page ��ҳ����
	 * @return �û�����
	 */
	public int findByCount(Page page);
	
	/**
	 * �����������ҷ�ҳ�������
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List findByPage(Page page);
	
	
	/**
	 * �������������û������������Ҫ��ͬʱ����
	 * @param user �������������� user ����
	 * @return �������������ĵ�һ�� user �������û�з��������ͷ��� null
	 */
	public List<User> findByExample(User user);
	
	
	/**
	 * �����û�����
	 * @param id ������������û�ID
	 * @return ���ý��
	 */
	public Integer resetPassword(long id);
	
}
