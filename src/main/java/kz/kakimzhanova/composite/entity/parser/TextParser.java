package kz.kakimzhanova.composite.entity.parser;

import kz.kakimzhanova.composite.entity.CompositeType;

public class TextParser extends AbstractParser {
    public TextParser(AbstractParser successor) {
        super(successor, CompositeType.TEXT);
    }

    public String[] parse (String s){
        return s.split("\n");
    }
}
