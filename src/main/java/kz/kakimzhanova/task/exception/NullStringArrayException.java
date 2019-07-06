package kz.kakimzhanova.task.exception;

public class NullStringArrayException extends Exception{
    public NullStringArrayException() {
    }

    public NullStringArrayException(String s) {
        super(s);
    }

    public NullStringArrayException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NullStringArrayException(Throwable throwable) {
        super(throwable);
    }
}
