package kz.kakimzhanova.task.action.counter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WordCounter {
    private static Logger logger = LogManager.getLogger();

    public int countWords(List<Component> lexemes){
        int count = 0;
        try {
            for (Component lexeme : lexemes){
                for (Component leaf : lexeme.getComponentList()) {
                    if (leaf.getType() == ComponentType.WORD) {
                        count++;
                    }
                }
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }

        return count;
    }
    public int countWordLength(Component component){
        int count = 0;
        if (component.getType() == ComponentType.WORD){
            try {
                count = component.getString().length();
            } catch (MethodNotSupportedException e) {
                logger.log(Level.WARN, e);
            }
        }
        return count;
    }

}
