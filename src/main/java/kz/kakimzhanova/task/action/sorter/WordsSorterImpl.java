package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.action.counter.WordsLengthCounter;
import kz.kakimzhanova.task.action.counter.WordsLengthCounterImpl;
import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class WordsSorterImpl implements WordsSorter {
    private static Logger logger = LogManager.getLogger();
    @Override
    public List<Component> sortWordsByLength(List<Component> lexemes) throws WrongParameterTypeException{
        for (Component lexeme : lexemes){
            if (lexeme.getType() != ComponentType.LEXEME){
                throw new WrongParameterTypeException("List of lexemes expected, got " + lexeme.getType());
            }
        }
        List<Component> words = new ArrayList<>();
        try {

            for (Component lexeme : lexemes) {
                for (Component leaf : lexeme.getComponentList()){
                    if (leaf.getType() == ComponentType.WORD){
                        words.add(leaf);
                    }
                }
            }
        }catch (MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }
        List<Component> sortedWords = new ArrayList<>(words);
        sortedWords.sort((Component firstWord, Component secondWord) -> {
            WordsLengthCounter wordLengthCounter = new WordsLengthCounterImpl();
            int result = -1;
            try {
                result =  wordLengthCounter.countWordLength(firstWord)
                        - wordLengthCounter.countWordLength(secondWord);
            } catch (WrongParameterTypeException e) {
                logger.log(Level.WARN, e);
            }
            return result;
        });
        return sortedWords;
    }
}
