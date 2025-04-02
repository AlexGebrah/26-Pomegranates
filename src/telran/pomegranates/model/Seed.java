package telran.pomegranates.model;

import java.util.Objects;

public class Seed {
    private double weight;

    public Seed(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Seed seed)) return false;
        return Double.compare(weight, seed.weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(weight);
    }
}
