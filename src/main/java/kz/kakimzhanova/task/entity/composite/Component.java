package kz.kakimzhanova.task.entity.composite;

import kz.kakimzhanova.task.exception.AddNotSupportedException;

public interface Component {
    int count();
    void add(Component component) throws AddNotSupportedException;
    String reconstruct();
}
