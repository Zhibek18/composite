package kz.kakimzhanova.task.entity.composite;

import kz.kakimzhanova.task.util.IdGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite implements Component {
    private long id;
    private List<Component> components = new ArrayList<>();
    private ComponentType componentType;

    public Composite(ComponentType componentType){
        id = IdGenerator.generateCompositeId();
        this.componentType = componentType;
    }

    public void add(Component component){
        components.add(component);
    }

    public int count(){
        return components.size();
    }
    public void remove(int i){
        components.remove(i);
    }

    public List<Component> getComponentList(){
        return Collections.unmodifiableList(components);
    }

    public String reconstruct() {
        StringBuilder s = new StringBuilder();
        for (Component component : components){
            s.append(component.reconstruct());
        }
        switch (componentType){
            case PARAGRAPH: s.append("\n");
                            break;
            case LEXEME:    s.append(" ");
                            break;
            default:
        }
        return s.toString();
    }
    public ComponentType getType(){
        return componentType;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("id = ");
        s.append(id);
        s.append(" type: ");
        s.append(componentType);
        s.append("\n");
        if (components == null){
            s.append("empty components");
            return s.toString();
        }
        for (Component component : components) {
            s.append(component);
        }
        return s.toString();
    }
}
