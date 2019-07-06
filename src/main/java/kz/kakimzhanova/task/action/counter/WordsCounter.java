package kz.kakimzhanova.task.action.counter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;

import java.util.List;

public interface WordsCounter {
    int countWords(List<Component> lexemes) throws WrongParameterTypeException;
}
