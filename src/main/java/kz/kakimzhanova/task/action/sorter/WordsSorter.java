package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.action.counter.WordCounter;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class WordsSorter {
    private static Logger logger = LogManager.getLogger();
    public List<Component> sortWordsByLength(List<Component> lexemes){
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
            WordCounter wordCounter = new WordCounter();
            return wordCounter.countWordLength(firstWord) - wordCounter.countWordLength(secondWord);
        });
        return sortedWords;
    }
}
