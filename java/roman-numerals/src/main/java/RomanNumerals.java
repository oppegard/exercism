import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeral {
    private final static LinkedHashMap<Integer, String> orderedNumeralMappings = new LinkedHashMap<>() {
        {
            put(1000, "M" );
            put( 900, "CM");
            put( 500, "D" );
            put( 400, "CD");
            put( 100, "C" );
            put(  90, "XC");
            put(  50, "L" );
            put(  40, "XL");
            put(  10, "X" );
            put(   9, "IX");
            put(   5, "V" );
            put(   4, "IV");
            put(   1, "I" );
        }
    };
    private String romanNumeral = "";

    RomanNumeral(int value) {
        for (Map.Entry<Integer, String> entry : orderedNumeralMappings.entrySet()) {
            while (value - entry.getKey() >= 0) {
                value = value - entry.getKey();
                this.romanNumeral += entry.getValue();
            }
        }
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}