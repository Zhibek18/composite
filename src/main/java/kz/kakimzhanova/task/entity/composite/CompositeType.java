package kz.kakimzhanova.task.entity.composite;

public enum CompositeType {
    TEXT(""), PARAGRAPH("\n"), SENTENCE(". "), LEXEME(" ");

    private String end;
    CompositeType(String end){
        this.end = end;
    }

    public String getEnd() {
        return end;
    }
}
