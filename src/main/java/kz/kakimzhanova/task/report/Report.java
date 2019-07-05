package kz.kakimzhanova.task.report;

import kz.kakimzhanova.task.action.sorter.SentenceSorter;
import kz.kakimzhanova.task.action.sorter.WordsSorter;
import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.action.sorter.ParagraphSorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Report {
    private static Logger logger = LogManager.getLogger();

    public void printComponentReport(Component component){
        logger.log(Level.INFO, component);
    }

    public void printSortedParagraphs(Component text){
        ParagraphSorter paragraphSorter = new ParagraphSorter();
        try {
            List<Component> sortedParagraphs = paragraphSorter.sortParagraphBySentenceCount(text.getComponentList());
            logger.log(Level.INFO, "Paragraphs sorted by sentences count:");
            for (Component paragraph : sortedParagraphs){
                logger.log(Level.INFO, paragraph.reconstruct());
            }
        }catch (MethodNotSupportedException e){
            logger.log(Level.WARN, e);
        }
    }

    public void printSortedSentences(Component text){
        SentenceSorter sentenceSorter = new SentenceSorter();
        logger.log(Level.INFO, "Sentences sorted by words count: ");
        try{
            for (Component paragraph : text.getComponentList()) {
                logger.log(Level.INFO, "TYPE: "+paragraph.getType() +" " +paragraph.reconstruct());
                List<Component> sortedSentences = sentenceSorter.sortSentenceByWordsCount(paragraph.getComponentList());
                for (Component sentence : sortedSentences) {
                    logger.log(Level.INFO, sentence.reconstruct());
                }
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }
    }

    public void printSortedWords(Component text){
        WordsSorter wordsSorter = new WordsSorter();
        logger.log(Level.INFO, "Words sorted by length: ");
        try{
            for (Component paragraph : text.getComponentList()) {
                for (Component sentence : paragraph.getComponentList()) {
                    logger.log(Level.INFO, "TYPE: " + sentence.getType() +" "+ sentence.reconstruct());
                    List<Component> sortedWords = wordsSorter.sortWordsByLength(sentence.getComponentList());
                    for (Component word : sortedWords) {
                        logger.log(Level.INFO, word.reconstruct());
                    }
                }
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }

    }
    public void printReconstructedText(Component component){
        logger.log(Level.INFO, "Reconstructed text:\n" + component.reconstruct());
    }
}
