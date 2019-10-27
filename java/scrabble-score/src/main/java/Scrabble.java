import java.util.HashMap;
import java.util.Map;

class Scrabble {
    private static final Map<Character, Integer> LETTER_VALUES = new HashMap<>() {
        {
            put('A', 1);
            put('B', 3);
            put('C', 3);
            put('D', 2);
            put('E', 1);
            put('F', 4);
            put('G', 2);
            put('H', 4);
            put('I', 1);
            put('J', 8);
            put('K', 5);
            put('L', 1);
            put('M', 3);
            put('N', 1);
            put('O', 1);
            put('P', 3);
            put('Q', 10);
            put('R', 1);
            put('S', 1);
            put('T', 1);
            put('U', 1);
            put('V', 4);
            put('W', 4);
            put('X', 8);
            put('Y', 4);
            put('Z', 10);
        }
    };
    private final String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        Integer score = 0;
        for (Character letter : word.toUpperCase().toCharArray()) {
            score += LETTER_VALUES.getOrDefault(letter, 0);
        }
        return score;
    }
}
