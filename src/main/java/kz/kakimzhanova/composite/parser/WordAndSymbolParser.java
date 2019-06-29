package kz.kakimzhanova.composite.parser;

import kz.kakimzhanova.composite.entity.Component;
import kz.kakimzhanova.composite.entity.Leaf;
import kz.kakimzhanova.composite.entity.LeafType;

public class WordAndSymbolParser extends AbstractParser{
    @Override
    public String[] parse(String s) {
        return new String[0];
    }
    @Override
    public Component chain(String s){
        LeafType leafType = LeafType.SYMBOL;
        if (s.matches("\\w")){
            leafType = LeafType.WORD;
        }

        return new Leaf(s, leafType);
    }
}
