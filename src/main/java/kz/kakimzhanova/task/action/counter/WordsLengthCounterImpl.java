package kz.kakimzhanova.task.action.counter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;


public class WordsLengthCounterImpl implements WordsLengthCounter{
    @Override
    public int countWordLength(Component component) throws WrongParameterTypeException {
        int count;
        if (component.getType() == ComponentType.WORD){
            count = component.reconstruct().length();
        } else {
            throw new WrongParameterTypeException("WORD component was expected, got " + component.getType());
        }
        return count;
    }
}
