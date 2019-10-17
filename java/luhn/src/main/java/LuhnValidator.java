class LuhnValidator {

    boolean isValid(String candidate) {
        final String reversed = new StringBuilder(candidate).reverse().toString().replace(" ", "");
        if (!hasValidCharacters(reversed)) return false;

        int sum = 0;
        for (int i = 0; i < reversed.length(); i++) {
            int numericValue = Character.getNumericValue(reversed.charAt(i));
            sum += (i % 2 == 0) ? numericValue : calculateOddValue(numericValue);
        }
        return (sum % 10 == 0);
    }

    private boolean hasValidCharacters(String s) {
        return s.matches("\\d{2,}");
    }

    private int calculateOddValue(int value) {
        value = value * 2;
        return value > 9 ? value - 9 : value;
    }

}
