package spring5_rest_study.exception;

@SuppressWarnings("serial")
public class MemberNotFoundException extends RuntimeException {

	public MemberNotFoundException() {
	}

	public MemberNotFoundException(String message) {
		super(message);
	}

}
