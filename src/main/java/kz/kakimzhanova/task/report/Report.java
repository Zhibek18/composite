package kz.kakimzhanova.task.report;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.sorter.TextSorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Report {
    private static Logger logger = LogManager.getLogger();
    public void printComponentReport(Component component){
        logger.log(Level.INFO, component);
        TextSorter textSorter = new TextSorter();
        try {
             List<Component> list = textSorter.sortParagraphBySentenceCount(component.getComponentList());
             logger.log(Level.INFO, "Paragraphs sorted by sentences count");
             for (Component comp : list){
                 logger.log(Level.INFO, comp);
             }
        }catch (MethodNotSupportedException e){
            logger.log(Level.WARN, e);
        }
    }
    public void printReconstructedText(Component component){
        logger.log(Level.INFO, "Reconstructed text:\n" + component.reconstruct());
    }
}
