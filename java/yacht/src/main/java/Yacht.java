import java.util.stream.IntStream;

class Yacht {

    private static final int ZERO_SCORE = 0;
    private final int sum;
    private final int[] tallys;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.sum           = IntStream.of(dice).sum();
        this.tallys        = generateTallys(dice);
        this.yachtCategory = yachtCategory;
    }

    private int[] generateTallys(int[] dice) {
        int[] tallys = new int[6];
        for (int die : dice) tallys[die - 1] += 1;
        return tallys;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT:
                return calculateYacht();
            case FULL_HOUSE:
                return calculateFullHouse();
            case CHOICE:
                return this.sum;
            case FOUR_OF_A_KIND:
                return calculateFourOfAKind();
            case LITTLE_STRAIGHT:
            case BIG_STRAIGHT:
                return calculateStraight(yachtCategory);
            case ONES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                return calculateN(yachtCategory.ordinal());
            default:
                return ZERO_SCORE;
        }
    }

    private int calculateYacht() {
        for (int tally : tallys) {
            if (tally == 5) return 50;
        }
        return ZERO_SCORE;
    }

    private int calculateFullHouse() {
        boolean foundTwoOfAKind = false;
        boolean foundThreeOfAKind = false;

        for (int tally : tallys) {
            if (tally == 2) foundTwoOfAKind = true;
            if (tally == 3) foundThreeOfAKind = true;
        }

        return (foundTwoOfAKind && foundThreeOfAKind) ? this.sum : ZERO_SCORE;
    }

    private int calculateFourOfAKind() {
        for (int i = 0; i < tallys.length; i++) {
            if (tallys[i] >= 4) return (i + 1) * 4;
        }

        return ZERO_SCORE;
    }

    private int calculateStraight(YachtCategory yachtCategory) {
        int offset = (yachtCategory == YachtCategory.LITTLE_STRAIGHT) ? 0 : 1;

        for (int i = offset; i < 5 + offset; i++) {
            if (tallys[i] != 1) return ZERO_SCORE;
        }

        return 30;
    }

    private int calculateN(int n) {
        return tallys[n - 1] * n;
    }

}
