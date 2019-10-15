import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Anagram {
    private final Predicate<String> notSameWord;
    private final Predicate<String> isMatch;

    Anagram(String anagram) {
        this.notSameWord = testWord -> !testWord.equalsIgnoreCase(anagram);
        this.isMatch     = testWord -> toLowerCaseSorted(testWord).equals(toLowerCaseSorted(anagram));
    }

    private String toLowerCaseSorted(String string) {
        return string.toLowerCase().chars()
            .mapToObj(a -> Character.toString((char) a))
            .sorted()
            .reduce("", (a, b) -> a + b);
    }

    List<String> match(List<String> words) {
        return words.stream()
            .filter(notSameWord)
            .filter(isMatch)
            .collect(Collectors.toList());
    }
}
