import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    int computeSquareOfSumTo(int input) {
        int sum = IntStream.rangeClosed(1, input).sum();
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).map(i -> i * i).sum();
    }
}
