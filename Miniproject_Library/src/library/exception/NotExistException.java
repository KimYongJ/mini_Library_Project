package library.exception;


public class NotExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotExistException(){}
	public NotExistException(String message){
		super(message);
	}
}