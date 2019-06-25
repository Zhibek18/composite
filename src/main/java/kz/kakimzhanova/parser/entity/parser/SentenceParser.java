package kz.kakimzhanova.parser.entity.parser;

import kz.kakimzhanova.parser.entity.CompositeType;

public class SentenceParser extends AbstractParser {

    public SentenceParser(AbstractParser successor){
        super(successor, CompositeType.SENTENCE);
    }

    public String[] parse (String s){
        return s.split(" ");
    }

}
