package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.Leaf;
import kz.kakimzhanova.task.entity.composite.LeafType;

public class WordAndSymbolParser extends AbstractParser{
    private static final String REGEX = "\\w";
    @Override
    public String[] parse(String s) {
        return new String[0];
    }
    @Override
    public Component chain(String s){
        LeafType leafType = LeafType.SYMBOL;
        if (s.matches(REGEX)){
            leafType = LeafType.WORD;
        }

        return new Leaf(s, leafType);
    }
}
