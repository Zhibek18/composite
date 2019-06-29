package kz.kakimzhanova.task.exception;

public class AddNotSupportedException extends Exception {
    public AddNotSupportedException() {
    }

    public AddNotSupportedException(String s) {
        super(s);
    }

    public AddNotSupportedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AddNotSupportedException(Throwable throwable) {
        super(throwable);
    }
}
