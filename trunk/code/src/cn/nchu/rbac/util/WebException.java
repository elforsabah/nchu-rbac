package cn.nchu.rbac.util;

/**
 * �Զ����쳣����
 * @author Administrator
 *
 */
public class WebException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WebException() {
		super();
	}
	
	public WebException(String msg) {
		super(msg);
	}
	
	public WebException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public WebException(Throwable cause) {
		super(cause);
	}

}
