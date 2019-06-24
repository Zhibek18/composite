package kz.kakimzhanova.parser.entity;

import kz.kakimzhanova.parser.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private long id;
    private List<Component> components = new ArrayList<Component>();

    public Composite(){
        id = IdGenerator.generateCompositeId();
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
}
