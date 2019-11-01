import java.util.stream.IntStream;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice          = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case ONES:
                return calculateN(1, dice);
            case TWOS:
                return calculateN(2, dice);
            case THREES:
                return calculateN(3, dice);
            case FOURS:
                return calculateN(4, dice);
            case FIVES:
                return calculateN(5, dice);
            case SIXES:
                return calculateN(6, dice);
            default:
                return 0;
        }
    }

    private int calculateN(int n, int[] dice) {
        return IntStream.of(dice).filter(i -> i == n).sum();
    }

}
