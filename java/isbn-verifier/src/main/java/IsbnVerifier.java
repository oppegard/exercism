class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = sanitizeInput(stringToVerify);
        if (!validInput(stringToVerify)) return false;

        int dividend = 0;
        int multiplier = 10;
        for (Character c : stringToVerify.toCharArray()) {
            int charToNumeric = c == 'X' ? 10 : Character.getNumericValue(c);
            dividend += charToNumeric * multiplier--;
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
