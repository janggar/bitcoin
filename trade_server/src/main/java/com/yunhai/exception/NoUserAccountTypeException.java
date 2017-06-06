package com.yunhai.exception;


public class NoUserAccountTypeException extends PlatFormException {


    /**
	 * @Fields  serialVersionUID 
	 */
	private static final long serialVersionUID = 6678533741521400934L;

	public NoUserAccountTypeException() {
    }

    public NoUserAccountTypeException(final String arg0) {
        super(arg0);
    }

    public NoUserAccountTypeException(final Throwable arg0) {
        super(arg0);
    }

    public NoUserAccountTypeException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

}
