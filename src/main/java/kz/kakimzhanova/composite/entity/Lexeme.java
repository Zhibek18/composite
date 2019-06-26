package kz.kakimzhanova.composite.entity;

import kz.kakimzhanova.composite.exception.AddNotSupportedException;
import kz.kakimzhanova.composite.util.IdGenerator;

public class Lexeme implements Component {
    private long id;
    private String str;
    public Lexeme(String str){
        id = IdGenerator.generateLeafId();
        this.str = str;
    }
    public int count(){
        return 1;
    }
    public void add(Component component) throws AddNotSupportedException{
        throw new AddNotSupportedException("Add not supported in Lexeme class");
    }

    public String reconstruct() {
        return str + " ";
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("id = ");
        s.append(id);
        s.append("\n");
        s.append(str);
        s.append("\n");
        return s.toString();
    }
}
