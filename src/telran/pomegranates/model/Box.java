package telran.pomegranates.model;

import java.util.Iterator;
import java.util.List;

public class Box implements Iterable {
    public String name;
    public List<Pomegranate> granates;

    public Box(String name, List<Pomegranate> granates) {
        this.name = name;
        this.granates = granates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGranates(List<Pomegranate> granates) {
        this.granates = granates;
    }

    @Override
    public String toString() {
        return "Box{" +
                "name='" + name + '\'' +
                ", granates=" + granates +
                '}';
    }

    @Override
    public Iterator iterator() {
        return granates.iterator();
    }
}
