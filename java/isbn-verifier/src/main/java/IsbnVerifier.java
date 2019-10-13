class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = sanitizeInput(stringToVerify);
        if (!validInput(stringToVerify)) return false;

        int dividend = 0;
        int counter = 0;
        for (int multiplier = 10; multiplier > 0; multiplier--) {
            int charToDigit = Character.getNumericValue(stringToVerify.charAt(counter++));
            if (charToDigit == Character.getNumericValue('X')) charToDigit = 10;
            dividend += charToDigit * multiplier;
        }

        return (dividend % 11 == 0);
    }

    private String sanitizeInput(String input) {
        return input.replace("-", "");
    }

    private boolean validInput(String input) {
        return input.matches("[0-9]{9}[0-9,X]");
    }
}
