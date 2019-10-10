public class PhoneNumber {
    private final String number;

    PhoneNumber(String input) {
        checkUnpermittedCharacters(input);
        input = onlyDigits(input);
        input = checkLength(input);

        checkStartsWithZeroOrOne(input.substring(0, 3), "area code");
        checkStartsWithZeroOrOne(input.substring(3, 6), "exchange code");
        this.number = input;
    }

    private void checkUnpermittedCharacters(String input) {
        if (input.toLowerCase().matches(".*[a-z]+.*")) throw new IllegalArgumentException("letters not permitted");
        if (input.matches(".*[@,:,!]+.*")) throw new IllegalArgumentException("punctuations not permitted");
    }

    private String onlyDigits(String input) {
        StringBuilder justDigits = new StringBuilder();
        for (Character character : input.toCharArray())
            if (character.toString().matches("[0-9]")) justDigits.append(character);
        return justDigits.toString();
    }

    private String checkLength(String input) {
        if (input.length() < 10) throw new IllegalArgumentException("incorrect number of digits");
        if (input.length() > 11) throw new IllegalArgumentException("more than 11 digits");
        if (input.length() == 11) {
            if (input.startsWith("1")) {
                input = input.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }
        return input;
    }

    private void checkStartsWithZeroOrOne(String digits, String thing) {
        if (digits.startsWith("0")) throw new IllegalArgumentException(thing + " cannot start with zero");
        if (digits.startsWith("1")) throw new IllegalArgumentException(thing + " cannot start with one");
    }

    public String getNumber() {
        return this.number;
    }
}