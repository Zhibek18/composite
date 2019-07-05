package kz.kakimzhanova.task.action.sorter;
import kz.kakimzhanova.task.entity.composite.Component;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParagraphSorter {
    public List<Component> sortParagraphBySentenceCount(List<Component> paragraphs){
            return sortListByCount(paragraphs);
    }

    private List<Component> sortListByCount(List<Component> components){
        List<Component> sortedList = new ArrayList<>(components);
        sortedList.sort(Comparator.comparing(Component::count));
        return sortedList;
    }
}
