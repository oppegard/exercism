import java.util.List;
import java.util.stream.Collectors;

class Anagram {
    private final String anagram;

    Anagram(String anagram) {
        this.anagram = anagram;
    }

    List<String> match(List<String> words) {
        return words.stream()
            .filter(this::isNotSameWordAsAnagram)
            .filter(this::isAnagram)
            .collect(Collectors.toList());
    }

    private boolean isNotSameWordAsAnagram(String word) {
        return !anagram.equalsIgnoreCase(word);
    }

    private boolean isAnagram(String word) {
        return toLowerCaseSorted(word).equals(toLowerCaseSorted(anagram));
    }

    private String toLowerCaseSorted(String string) {
        return string.toLowerCase().chars()
            .mapToObj(a -> Character.toString((char) a))
            .sorted()
            .reduce("", (a, b) -> a + b);
    }
}