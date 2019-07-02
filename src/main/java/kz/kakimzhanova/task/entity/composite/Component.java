package kz.kakimzhanova.task.entity.composite;

import kz.kakimzhanova.task.exception.MethodNotSupportedException;

import java.util.List;

public interface Component {
    int count();
    void add(Component component) throws MethodNotSupportedException;
    String reconstruct();
    List <Component> getComponentList() throws MethodNotSupportedException;
}
