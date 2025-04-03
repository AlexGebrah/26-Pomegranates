package telran.pomegranates;

import telran.pomegranates.model.Box;
import telran.pomegranates.model.Pomegranate;
import telran.pomegranates.model.Seed;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PomegranatesAppl {
    public static void main(String[] args) {
        List<Box> boxes = generateBoxes(100, 200);

        int totalSeeds = boxes.stream()
                .flatMap(box -> box.granates.stream())
                .flatMap(pomegranate -> pomegranate.seeds.stream())
                .mapToInt(seed -> 1)
                .sum();
        System.out.println("Total seeds in all boxes: " + totalSeeds);

        int maxSeeds = boxes.stream()
                .mapToInt(box -> box.granates.stream()
                        .mapToInt(pomegranate -> pomegranate.seeds.size())
                        .sum())
                .max()
                .orElse(0);
        System.out.println("Maximum seeds in one box: " + maxSeeds);

        List<String> maxSeedBoxes = boxes.stream()
                .filter(box -> box.granates.stream()
                        .mapToInt(pomegranate -> pomegranate.seeds.size())
                        .sum() == maxSeeds)
                .map(box -> box.name)
                .toList();
        System.out.println("Boxes with maximum seeds: " + maxSeedBoxes);
    }

    public static List<Box> generateBoxes(int min, int max) {
        Random random = new Random();
        return Stream.generate(() -> new Box("Box " + System.nanoTime(), generatePomegranates(10, 20)))
                .limit(random.nextInt(max - min + 1) + min)
                .collect(Collectors.toList());
    }

    public static List<Pomegranate> generatePomegranates(int min, int max) {
        Random random = new Random();
        return
                Stream.generate(() -> new Pomegranate(generateSeeds(400, 700)))
                .limit(random.nextInt(max - min + 1) + min)
                .collect(Collectors.toList());
    }

    public static List<Seed> generateSeeds(int min, int max) {
        return new Random()
                .ints(min, max)
                .limit(new Random().nextInt(max - min + 1) + min)
                .mapToObj(i -> new Seed(2.0))
                .collect(Collectors.toList());
    }
}
