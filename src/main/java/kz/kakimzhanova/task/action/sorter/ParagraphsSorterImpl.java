package kz.kakimzhanova.task.action.sorter;
import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ParagraphsSorterImpl implements ParagraphsSorter {
    @Override
    public List<Component> sortParagraphBySentenceCount(List<Component> paragraphs) throws WrongParameterTypeException{
        for (Component paragraph : paragraphs){
            if (paragraph.getType() != ComponentType.PARAGRAPH){
                throw new WrongParameterTypeException("List of paragraphs expected, got " + paragraph.getType() );
            }
        }
        List<Component> sortedParagraphs = new ArrayList<>(paragraphs);
        sortedParagraphs.sort(Comparator.comparing(Component::count));
        return sortedParagraphs;
    }
}
