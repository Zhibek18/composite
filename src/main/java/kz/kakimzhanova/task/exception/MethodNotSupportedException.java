package kz.kakimzhanova.task.exception;

public class MethodNotSupportedException extends Exception {
    public MethodNotSupportedException() {
    }

    public MethodNotSupportedException(String s) {
        super(s);
    }

    public MethodNotSupportedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MethodNotSupportedException(Throwable throwable) {
        super(throwable);
    }
}
