import java.util.regex.Pattern;

public class PhoneNumber {
    private String number = "";

    PhoneNumber(String input) {
        this.number = "";

        checkUnpermittedCharacters(input);

        for(Character character: input.toCharArray()) {
            if(character.toString().matches("[0-9]")) this.number += character;
        }

        if (this.number.length() < 10) throw new IllegalArgumentException("incorrect number of digits");
        if (this.number.length() == 11) {
            if (!this.number.startsWith("1")) throw new IllegalArgumentException("11 digits must start with 1");
            this.number = this.number.substring(1);
        }
        if (this.number.length() > 11) throw new IllegalArgumentException("more than 11 digits");
        if (this.number.startsWith("0")) throw new IllegalArgumentException("area code cannot start with zero");
        if (this.number.startsWith("1")) throw new IllegalArgumentException("area code cannot start with one");
        if (this.number.startsWith("0", 3)) throw new IllegalArgumentException("exchange code cannot start with zero");
        if (this.number.startsWith("1", 3)) throw new IllegalArgumentException("exchange code cannot start with one");
    }

    private void checkUnpermittedCharacters(String input) {
        if (input.toLowerCase().matches(".*[a-z]+.*")) throw new IllegalArgumentException("letters not permitted");
        if (input.matches(".*[@,:,!]+.*")) throw new IllegalArgumentException("punctuations not permitted");
    }

    public String getNumber() {
        return this.number;
    }
}