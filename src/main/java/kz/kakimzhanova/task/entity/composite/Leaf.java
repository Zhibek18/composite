package kz.kakimzhanova.task.entity.composite;

import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Leaf implements Component {
    Logger logger = LogManager.getLogger();
    private long id;
    private String str;
    private ComponentType componentType;
    public Leaf(String str, ComponentType componentType){
        id = IdGenerator.generateLeafId();
        this.str = str;
        this.componentType = componentType;
    }
    public int count(){
        return 1;
    }
    public void add(Component component) throws MethodNotSupportedException {
        throw new MethodNotSupportedException("Add is not supported in Leaf class");
    }

    public String reconstruct() {
        return str;
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
        s.append(str);
        s.append("\n");
        return s.toString();
    }
}
