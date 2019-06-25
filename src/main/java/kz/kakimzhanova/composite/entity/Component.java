package kz.kakimzhanova.composite.entity;

import kz.kakimzhanova.composite.exception.AddNotSupportedException;

public interface Component {
    int count();
    void add(Component component) throws AddNotSupportedException;
}
