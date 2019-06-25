package kz.kakimzhanova.parser.entity;

import kz.kakimzhanova.parser.exception.AddNotSupportedException;

public interface Component {
    int count();
    void add(Component component) throws AddNotSupportedException;
}
