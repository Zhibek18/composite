package kz.kakimzhanova.task.action.sorter;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.exception.WrongParameterTypeException;

import java.util.List;

public interface ParagraphsSorter {
    List<Component> sortParagraphBySentencesCount(List<Component> paragraphs) throws WrongParameterTypeException;
}
