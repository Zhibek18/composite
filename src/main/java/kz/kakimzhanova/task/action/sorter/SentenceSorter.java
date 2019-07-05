package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.action.counter.WordCounter;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SentenceSorter {
    private static Logger logger = LogManager.getLogger();

    public List<Component> sortSentenceByWordsCount(List<Component> sentences) {
        List<Component> sortedSentences = new ArrayList<>(sentences);
        sortedSentences.sort((Component firstSentence, Component secondSentence) -> {
            int result = -1;
            try {
                WordCounter wordCounter = new WordCounter();
                result = wordCounter.countWords(firstSentence.getComponentList()) - wordCounter.countWords(secondSentence.getComponentList());
            } catch (MethodNotSupportedException e) {
                logger.log(Level.WARN, e);
            }
            return result;
        });
        return sortedSentences;
    }
}
