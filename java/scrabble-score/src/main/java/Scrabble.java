import java.util.*;

class Scrabble {
    private static final Map<Integer, Set<Character>> LETTER_VALUES = new HashMap<>() {
        {
            put( 1, new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')));
            put( 2, new HashSet<>(Arrays.asList('D', 'G'                                        )));
            put( 3, new HashSet<>(Arrays.asList('B', 'C', 'M', 'P'                              )));
            put( 4, new HashSet<>(Arrays.asList('F', 'H', 'V', 'W', 'Y'                         )));
            put( 5, new HashSet<>(Arrays.asList('K'                                             )));
            put( 8, new HashSet<>(Arrays.asList('J', 'X'                                        )));
            put(10, new HashSet<>(Arrays.asList('Q', 'Z'                                        )));
        }
    };
    private final String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        Integer score = 0;
        for (Character letter : word.toUpperCase().toCharArray()) {
            for (Map.Entry<Integer, Set<Character>> entry : LETTER_VALUES.entrySet()) {
                if (entry.getValue().contains(letter)) score += entry.getKey();
            }
        }
        return score;
    }
}
