package model.personsLifeCounter.components;

/**
 * Exception for output error message
 * @author Igor Stojanovic
 *
 */
public class ErrorException extends Throwable {

	private static final long serialVersionUID = 123;
	private String message;
	
	/**
	 * The input message is set in variable {@code message}
	 * When exception is thrown message is returned through method {@code toString()}
	 * 
	 * @see {@link #toString()}
	 * @param message to output
	 */
	public ErrorException(String message) {
		this.message = message;
	}
	
	/**
	 * @return message to output
	 */
	public String toString() {
		return message;
	}
}
