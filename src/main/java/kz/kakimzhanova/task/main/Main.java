package kz.kakimzhanova.task.main;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.NullStringArrayException;
import kz.kakimzhanova.task.parser.*;
import kz.kakimzhanova.task.reader.Reader;
import kz.kakimzhanova.task.report.Report;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        Reader reader = new Reader();
        try {
            String s = reader.readText("text.txt");
            AbstractParser wordAndSymbolParser = new WordAndSymbolParser();
            AbstractParser lexemeParser = new LexemeParser(wordAndSymbolParser);
            AbstractParser sentenceParser = new SentenceParser(lexemeParser);
            AbstractParser paragraphParser = new ParagraphParser(sentenceParser);
            AbstractParser textParser = new TextParser(paragraphParser);

            Component component = textParser.chain(s);
            Report report = new Report();

            report.printComponentReport(component);
            report.printReconstructedText(component);
            report.printSortedParagraphs(component);
            report.printSortedSentences(component);
            report.printSortedWords(component);
        }catch (IOException |NullStringArrayException | MethodNotSupportedException e) {
            logger.log(Level.WARN, e);
        }
    }
}
