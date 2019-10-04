import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static final Character[] ONE_POINTERS   = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
    private static final Character[] TWO_POINTERS   = {'D', 'G'};
    private static final Character[] THREE_POINTERS = {'B', 'C', 'M', 'P'};
    private static final Character[] FOUR_POINTERS  = {'F', 'H', 'V', 'W', 'Y'};
    private static final Character[] FIVE_POINTERS  = {'K'};
    private static final Character[] EIGHT_POINTERS = {'J', 'X'};
    private static final Character[] TEN_POINTERS   = {'Q', 'Z'};
    private static final Map<Character[], Integer> LETTER_VALUES;
    private final String word;

    static {
        Map<Character[], Integer> aMap = new HashMap<>();
        aMap.put(ONE_POINTERS,   1);
        aMap.put(TWO_POINTERS,   2);
        aMap.put(THREE_POINTERS, 3);
        aMap.put(FOUR_POINTERS,  4);
        aMap.put(FIVE_POINTERS,  5);
        aMap.put(EIGHT_POINTERS, 8);
        aMap.put(TEN_POINTERS,  10);
        for (Character[] letterSet : aMap.keySet()) Arrays.sort(letterSet);

        LETTER_VALUES = Collections.unmodifiableMap(aMap);
    }

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int score = 0;

        for (char letter : word.toCharArray()) {
            letter = Character.toUpperCase(letter);

            for (Map.Entry<Character[], Integer> entry : LETTER_VALUES.entrySet()) {
                Character[] letterSet = entry.getKey();
                Integer pointValue = entry.getValue();
                if (Arrays.binarySearch(letterSet, letter) >= 0) score += pointValue;
            }
        }
        return score;
    }

}
