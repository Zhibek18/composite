package kz.kakimzhanova.parser.entity.parser;

import kz.kakimzhanova.parser.entity.Component;
import kz.kakimzhanova.parser.entity.Lexeme;

public class LexemeParser extends AbstractParser {

    @Override
    public String[] parse (String s) {
        return null;
    }
    @Override
    public Component chain(String s){
        return new Lexeme(s);
    }
}
