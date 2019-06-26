package kz.kakimzhanova.composite.main;

import kz.kakimzhanova.composite.entity.Component;
import kz.kakimzhanova.composite.entity.parser.*;
import kz.kakimzhanova.composite.reader.Reader;
import kz.kakimzhanova.composite.report.Report;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        //String s = "Hello World. \n I am your new king. Bow to me!";
        Reader reader = new Reader();
        try {
            String s = reader.readText("test.txt");

            AbstractParser lexemeParser = new LexemeParser();
            AbstractParser sentenceParser = new SentenceParser(lexemeParser);
            AbstractParser paragraphParser = new ParagraphParser(sentenceParser);
            AbstractParser textParser = new TextParser(paragraphParser);

            Component component = textParser.chain(s);
            Report report = new Report();
            report.printComponentReport(component);
        }catch (IOException e){
            logger.log(Level.WARN, e);
        }
    }
}
