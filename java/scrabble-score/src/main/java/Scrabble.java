import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Scrabble {
    private static final Map<Integer, Character[]> LETTER_VALUES = new HashMap<>() {
        {
            put( 1, new Character[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'});
            put( 2, new Character[]{'D', 'G'                                        });
            put( 3, new Character[]{'B', 'C', 'M', 'P'                              });
            put( 4, new Character[]{'F', 'H', 'V', 'W', 'Y'                         });
            put( 5, new Character[]{'K',                                            });
            put( 8, new Character[]{'J', 'X'                                        });
            put(10, new Character[]{'Q', 'Z'                                        });

            for (Character[] letterSet : values()) Arrays.sort(letterSet);
        }
    };
    private final String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        int score = 0;

        for (char letter : word.toUpperCase().toCharArray()) {
            for (Map.Entry<Integer, Character[]> entry : LETTER_VALUES.entrySet()) {
                Integer pointValue = entry.getKey();
                Character[] letterSet = entry.getValue();
                if (Arrays.binarySearch(letterSet, letter) >= 0) score += pointValue;
            }
        }
        return score;
    }
}
