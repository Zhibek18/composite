package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.Leaf;
import kz.kakimzhanova.task.entity.composite.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSymbolParser extends AbstractParser{
    private static final String REGEX = "\\W";
    @Override
    public String[] parse(String s) {
        return new String[0];
    }
    @Override
    public Component chain(String s){
        ComponentType componentType = ComponentType.WORD;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()){
            componentType = ComponentType.SYMBOL;
        }

        return new Leaf(s, componentType);
    }
}
