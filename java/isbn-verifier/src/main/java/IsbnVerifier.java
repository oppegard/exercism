class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = sanitizeInput(stringToVerify);
        if (!isValidFormat(stringToVerify)) return false;

        int isbnSum = calculateIsbnSum(stringToVerify);
        return (isbnSum % 11 == 0);
    }

    private String sanitizeInput(String input) {
        return input.replace("-", "");
    }

    private boolean isValidFormat(String input) {
        return input.matches("^[0-9]{9}[0-9,X]$");
    }

    private int calculateIsbnSum(String stringToVerify) {
        int isbnSum = 0, multiplier = 10;
        for (Character c : stringToVerify.toCharArray()) {
            int numericValue = c == 'X' ? 10 : Character.getNumericValue(c);
            isbnSum += numericValue * multiplier--;
        }
        return isbnSum;
    }
}
