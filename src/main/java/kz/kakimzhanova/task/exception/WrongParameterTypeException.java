package kz.kakimzhanova.task.exception;

public class WrongParameterTypeException extends Exception {
    public WrongParameterTypeException() {
    }

    public WrongParameterTypeException(String s) {
        super(s);
    }

    public WrongParameterTypeException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WrongParameterTypeException(Throwable throwable) {
        super(throwable);
    }
}
