package exceptions;

public class InvalidInputException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5280426672115001407L;

	public InvalidInputException(String s) {
		super(s);
	}
	
	public InvalidInputException(long n) {
		super("Invalid Input : " + n);
	}

}
