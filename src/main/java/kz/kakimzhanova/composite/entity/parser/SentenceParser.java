package kz.kakimzhanova.composite.entity.parser;

import kz.kakimzhanova.composite.entity.CompositeType;

public class SentenceParser extends AbstractParser {

    public SentenceParser(AbstractParser successor){
        super(successor, CompositeType.SENTENCE);
    }

    public String[] parse (String s){
        return s.split(" ");
    }

}
