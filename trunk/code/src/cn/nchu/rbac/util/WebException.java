package cn.nchu.rbac.util;

/**
 * 自定义异常对象
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
