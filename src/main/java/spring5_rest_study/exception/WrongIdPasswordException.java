package spring5_rest_study.exception;

@SuppressWarnings("serial")
public class WrongIdPasswordException extends RuntimeException {

	public WrongIdPasswordException() {
	}

	public WrongIdPasswordException(String message) {
		super(message);
	}

}
