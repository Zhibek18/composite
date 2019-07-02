package kz.kakimzhanova.task.entity.composite;

public enum ComponentType {
    TEXT(""), PARAGRAPH("\n\n"), SENTENCE(""), LEXEME(" "), WORD(""), SYMBOL("");

    private String end;
    ComponentType(String end){
        this.end = end;
    }

    public String getEnd() {
        return end;
    }
}
