package kz.kakimzhanova.parser.entity;

import kz.kakimzhanova.parser.util.IdGenerator;

public class Lexeme implements Component {
    private long id;

    public Lexeme(){
        id = IdGenerator.generateLeafId();
    }
    public int count(){
        return 1;
    }
}
