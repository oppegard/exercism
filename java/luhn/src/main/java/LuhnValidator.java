import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        final String reversed = new StringBuilder(candidate).reverse().toString().replace(" ", "");
        IntUnaryOperator intFunction = i -> {
            int value = Character.getNumericValue(reversed.charAt(i));

            if (i % 2 == 0) {
                return value;
            } else {
                value = value * 2;
                return value > 9 ? value - 9 : value;
            }
        };

        if (hasValidCharacters(reversed)) {
            int sum = IntStream.range(0, reversed.length())
                .map(intFunction).sum();
            return (sum % 10 == 0);
        } else {
            return false;
        }
    }

    private boolean hasValidCharacters(String candidate) {
        return candidate.length() > 1 && candidate.matches("[0-9, ]+");
    }

}
