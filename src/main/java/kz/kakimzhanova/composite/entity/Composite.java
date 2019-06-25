package kz.kakimzhanova.composite.entity;

import kz.kakimzhanova.composite.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private long id;
    private List<Component> components = new ArrayList<Component>();
    private CompositeType compositeType;

    public Composite(CompositeType compositeType){
        id = IdGenerator.generateCompositeId();
        this.compositeType = compositeType;
    }
    public void add(Component component){
        components.add(component);
    }

    public int count(){
        int count = 0;
        if (components != null) {
            for (Component component: components) {
                count += component.count();
            }
        }
        return count;
    }
    public void remove(int i){
        components.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("id = ");
        s.append(id);
        s.append(" type: ");
        s.append(compositeType);
        s.append("\n");
        if (components == null){
            s.append("empty components");
        }
        for (Component component : components) {
            s.append(component);
            s.append("\n");
        }
        return s.toString();
    }
}
