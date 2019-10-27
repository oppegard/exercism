class DifferenceOfSquaresCalculator {
    // Algorithm credit: https://www.geeksforgeeks.org/difference-between-sum-of-the-squares-of-first-n-natural-numbers-and-square-of-sum/

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    int computeSquareOfSumTo(int input) {
        int sum = (input * (input + 1)) / 2;
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * (2 * input + 1)) / 6;
    }
}
