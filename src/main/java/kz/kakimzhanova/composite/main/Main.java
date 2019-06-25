package kz.kakimzhanova.composite.main;

import kz.kakimzhanova.composite.entity.Component;
import kz.kakimzhanova.composite.entity.parser.*;
import kz.kakimzhanova.composite.report.Report;

public class Main {
    public static void main(String[] args) {
        //String s = "Hello World. \n I am your new king. Bow to me!";
        String s = "Hello.My name is Zhibek.\nkookok kkkk.";
        AbstractParser lexemeParser = new LexemeParser();
        AbstractParser sentenceParser = new SentenceParser(lexemeParser);
        AbstractParser paragraphParser = new ParagraphParser(sentenceParser);
        AbstractParser textParser = new TextParser(paragraphParser);

        Component component = textParser.chain(s);
        Report report = new Report();
        report.printComponentReport(component);
    }
}
