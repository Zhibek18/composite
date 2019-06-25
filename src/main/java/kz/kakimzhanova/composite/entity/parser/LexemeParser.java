package kz.kakimzhanova.composite.entity.parser;

import kz.kakimzhanova.composite.entity.Component;
import kz.kakimzhanova.composite.entity.Lexeme;

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