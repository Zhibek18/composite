package kz.kakimzhanova.task.action.counter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;

public interface WordsLengthCounter {
    int countWordLength(Component component) throws WrongParameterTypeException;
}
