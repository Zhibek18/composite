package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;

import java.util.List;

public interface WordsSorter {
    List<Component> sortWordsByLength(List<Component> lexemes) throws WrongParameterTypeException;
}
