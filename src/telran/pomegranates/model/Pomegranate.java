package telran.pomegranates.model;

import java.util.Iterator;
import java.util.List;

public class Pomegranate implements Iterable{
    public List<Seed> seeds;

    public Pomegranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    @Override
    public String toString() {
        return "Pomegranate{" +
                "seeds=" + seeds +
                '}';
    }

    @Override
    public Iterator iterator() {
        return seeds.iterator();
    }
}
