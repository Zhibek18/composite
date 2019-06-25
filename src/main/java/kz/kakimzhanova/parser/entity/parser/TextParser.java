package kz.kakimzhanova.parser.entity.parser;

import kz.kakimzhanova.parser.entity.Component;
import kz.kakimzhanova.parser.entity.CompositeType;

public class TextParser extends AbstractParser {
    public TextParser(AbstractParser successor) {
        super(successor, CompositeType.TEXT);
    }

    public String[] parse (String s){
        return s.split("\n");
    }
}
