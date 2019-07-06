package kz.kakimzhanova.task.action.counter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class WordsCounterImpl implements WordsCounter{
    private static Logger logger = LogManager.getLogger();

    @Override
    public int countWords(List<Component> lexemes) throws WrongParameterTypeException {
        int count = 0;
        try {
            for (Component lexeme : lexemes){
                if (lexeme.getType()==ComponentType.LEXEME) {
                    for (Component leaf : lexeme.getComponentList()) {
                        if (leaf.getType() == ComponentType.WORD) {
                            count++;
                        }
                    }
                } else{
                    throw new WrongParameterTypeException("List of Lexemes was expected, " + lexeme.getType());
                }
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }
        return count;
    }
}
