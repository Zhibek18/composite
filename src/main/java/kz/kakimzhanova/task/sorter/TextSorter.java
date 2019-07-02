package kz.kakimzhanova.task.sorter;

import kz.kakimzhanova.task.entity.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class TextSorter {
    public List<Component> sortParagraphBySentenceCount(List<Component> paragraphs){
        List<Component> sortedList = new ArrayList<>(paragraphs);
        sortedList.sort((Component par1, Component par2)->new Integer(par1.count()).compareTo(new Integer(par2.count())));
        return sortedList;
    }
}
