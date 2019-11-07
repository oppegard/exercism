import java.util.stream.IntStream;

class Yacht {

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

        for (int die : dice) {
            tallys[die - 1] += 1;
        }
        return tallys;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT:
                return isYacht() ? 50 : 0;
            case FULL_HOUSE:
                return isFullHouse() ? sum : 0;
            case CHOICE:
                return sum;
            case FOUR_OF_A_KIND:
                return calculateFourOfAKind();
            case LITTLE_STRAIGHT:
            case BIG_STRAIGHT:
                return isStraight(yachtCategory) ? 30 : 0;
            case ONES:
            case TWOS:
            case THREES:
            case FOURS:
            case FIVES:
            case SIXES:
                return calculateN(yachtCategory.ordinal());
            default:
                return 0;
        }
    }

    private boolean isYacht() {
        for (int tally : tallys) {
            if (tally == 5) return true;
        }
        return false;
    }

    private boolean isFullHouse() {
        boolean foundTwoOfAKind = false;
        boolean foundThreeOfAKind = false;

        for (int tally : tallys) {
            if (tally == 2) foundTwoOfAKind = true;
            if (tally == 3) foundThreeOfAKind = true;
        }

        return foundTwoOfAKind && foundThreeOfAKind;
    }

    private int calculateFourOfAKind() {
        for (int i = 0; i < tallys.length; i++) {
            if (tallys[i] >= 4) return (i + 1) * 4;
        }

        return 0;
    }

    private boolean isStraight(YachtCategory yachtCategory) {
        boolean isStraight = true;
        int offset = (yachtCategory == YachtCategory.LITTLE_STRAIGHT) ? 0 : 1;

        for (int i = offset; i < 5 + offset; i++) {
            if (tallys[i] != 1) isStraight = false;
        }

        return isStraight;
    }

    private int calculateN(int n) {
        return tallys[n - 1] * n;
    }

}
