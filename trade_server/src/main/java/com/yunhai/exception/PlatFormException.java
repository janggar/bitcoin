package com.yunhai.exception;

import java.io.Serializable;

/**
 * 异常类
 *
 * @author xs
 */
public class PlatFormException extends Exception implements Serializable {


    private static final long serialVersionUID = -227961057827878851L;

    @SuppressWarnings("unused")
    private int exceptionCode;

    public PlatFormException() {
    }

    public PlatFormException(String arg0) {
        super(arg0);
    }

    public PlatFormException(Throwable arg0) {
        super(arg0);
    }

    public PlatFormException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public PlatFormException(String arg0, Throwable arg1, int exceptionCode) {
        super(arg0, arg1);
        this.exceptionCode = exceptionCode;
    }
}