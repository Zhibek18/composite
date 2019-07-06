package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.action.counter.WordsCounter;
import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.action.counter.WordsCounterImpl;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SentencesSorterImpl implements SentencesSorter {
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Component> sortSentenceByWordsCount(List<Component> sentences) throws WrongParameterTypeException{
        for (Component sentence : sentences){
            if (sentence.getType() != ComponentType.SENTENCE){
                throw new WrongParameterTypeException("Expected list of sentences, got " + sentence.getType() );
            }
        }
        List<Component> sortedSentences = new ArrayList<>(sentences);
        sortedSentences.sort((Component firstSentence, Component secondSentence) -> {
            int result = -1;
            try {
                WordsCounter wordCounter = new WordsCounterImpl();
                result = wordCounter.countWords(firstSentence.getComponentList())
                        - wordCounter.countWords(secondSentence.getComponentList());
            } catch (MethodNotSupportedException| WrongParameterTypeException e) {
                logger.log(Level.WARN, e);
            }
            return result;
        });
        return sortedSentences;
    }
}
