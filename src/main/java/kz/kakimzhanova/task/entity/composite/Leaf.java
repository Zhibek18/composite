package kz.kakimzhanova.task.entity.composite;

import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.util.IdGenerator;
import java.util.List;

public class Leaf implements Component {
    private long id;
    private String symbols;
    private ComponentType componentType;

    public Leaf(String symbols, ComponentType componentType){
        id = IdGenerator.generateLeafId();
        this.symbols = symbols;
        this.componentType = componentType;
    }
    public int count(){
        return 1;
    }
    public void add(Component component) throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Add is not supported in Leaf class");
    }

    public String reconstruct() {
        return symbols;
    }
    public ComponentType getType(){
        return componentType;
    }
    @Override
    public List<Component> getComponentList() throws MethodNotSupportedException{
        throw new MethodNotSupportedException("getComponent is not supported in Leaf class");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("id = ");
        s.append(id);
        s.append(" type: ");
        s.append(componentType);
        s.append("\n");
        s.append(symbols);
        s.append("\n");
        return s.toString();
    }
}
