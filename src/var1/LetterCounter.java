package var1;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LetterCounter {
    Map<Character, Long> countedLetters;

    public LetterCounter(String string) {
        countedLetters = string.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public void printMaxLetter() {
        System.out.println("Most common letter:");
        System.out.println(countedLetters
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get());
    }

    public void printMinLetter() {
        System.out.println("Least common letter:");
        System.out.println(countedLetters
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get());
    }
}

