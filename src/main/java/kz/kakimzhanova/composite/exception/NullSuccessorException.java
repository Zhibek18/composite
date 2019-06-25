package kz.kakimzhanova.composite.exception;

public class NullSuccessorException extends Exception {
    public NullSuccessorException() {
    }

    public NullSuccessorException(String s) {
        super(s);
    }

    public NullSuccessorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NullSuccessorException(Throwable throwable) {
        super(throwable);
    }
}
