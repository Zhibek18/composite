package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.Leaf;
import kz.kakimzhanova.task.entity.composite.ComponentType;

public class WordAndSymbolParser extends AbstractParser{
    private static final String REGEX = "\\w";
    @Override
    public String[] parse(String s) {
        return new String[0];
    }
    @Override
    public Component chain(String s){
        ComponentType componentType = ComponentType.SYMBOL;
        if (s.matches(REGEX)){
            componentType = ComponentType.WORD;
        }

        return new Leaf(s, componentType);
    }
}
