package kz.kakimzhanova.task.report;

import kz.kakimzhanova.task.action.counter.WordsCounter;
import kz.kakimzhanova.task.action.counter.WordsCounterImpl;
import kz.kakimzhanova.task.action.sorter.*;
import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class Report {
    private static Logger logger = LogManager.getLogger();
    private static final String BORDER = "**************************************************************************\n";

    public void printComponentReport(Component component){
        logger.log(Level.INFO, component);
    }

    public void printSortedParagraphs(Component text){
        ParagraphsSorter paragraphsSorter = new ParagraphsSorterImpl();
        try {
            List<Component> sortedParagraphs = paragraphsSorter.sortParagraphBySentenceCount(text.getComponentList());
            logger.log(Level.INFO, "Paragraphs sorted by sentences count:\n" + BORDER);
            logger.log(Level.INFO, "Sorted paragraphs:");
            for (Component paragraph : sortedParagraphs){
                logger.log(Level.INFO,  paragraph.getType() +" sentence count = " + paragraph.count()
                        + " " + paragraph.reconstruct());
            }
        }catch (MethodNotSupportedException | WrongParameterTypeException e){
            logger.log(Level.WARN, e);
        }
    }

    public void printSortedSentences(Component text){
        SentencesSorter sentencesSorter = new SentencesSorterImpl();
        logger.log(Level.INFO, "Sentences sorted by words count:\n" + BORDER);
        try{
            for (Component paragraph : text.getComponentList()) {
                logger.log(Level.INFO, "Original: " + paragraph.getType());
                for (Component sentence : paragraph.getComponentList()) {
                    logger.log(Level.INFO,  sentence.getType() + " " + sentence.reconstruct());
                }
                WordsCounter wordCounter = new WordsCounterImpl();
                logger.log(Level.INFO, "Sorted sentences:");
                List<Component> sortedSentences = sentencesSorter.sortSentenceByWordsCount(paragraph.getComponentList());
                for (Component sentence : sortedSentences) {
                    logger.log(Level.INFO,  sentence.getType() + " words count = "
                            + wordCounter.countWords(sentence.getComponentList())  + " " +  sentence.reconstruct());
                }
            }
        } catch (MethodNotSupportedException| WrongParameterTypeException e) {
            logger.log(Level.WARN, e);
        }
    }

    public void printSortedWords(Component text){
        WordsSorter wordsSorter = new WordsSorterImpl();
        logger.log(Level.INFO, "Words sorted by length:\n" + BORDER);
        try{
            for (Component paragraph : text.getComponentList()) {
                for (Component sentence : paragraph.getComponentList()) {
                    logger.log(Level.INFO, sentence.getType() + " " + sentence.reconstruct());
                    logger.log(Level.INFO, "Sorted:");
                    List<Component> sortedWords = wordsSorter.sortWordsByLength(sentence.getComponentList());
                    for (Component word : sortedWords) {
                        logger.log(Level.INFO, word.reconstruct());
                    }
                }
            }
        } catch (MethodNotSupportedException | WrongParameterTypeException e) {
            logger.log(Level.WARN, e);
        }
    }
    public void printReconstructedText(Component component){
        logger.log(Level.INFO, "Reconstructed text:\n" + BORDER + component.reconstruct());
    }
}
