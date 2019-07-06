package kz.kakimzhanova.task.action.sorter;
import kz.kakimzhanova.task.entity.composite.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParagraphSorter {
    public List<Component> sortParagraphBySentenceCount(List<Component> paragraphs){
        List<Component> sortedParagraphs = new ArrayList<>(paragraphs);
        sortedParagraphs.sort(Comparator.comparing(Component::count));
        return sortedParagraphs;
    }
}
