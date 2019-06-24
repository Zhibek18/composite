package kz.kakimzhanova.parser.entity;

public abstract class AbstractParser {
    int id;
    abstract public Component parse (String s);
}
