import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeral {
    private String romanNumeral = "";

    RomanNumeral(int value) {
        final Map<Integer, String> orderedNumeralMappings = generateNumeralMappings();

        for (Map.Entry<Integer, String> entry : orderedNumeralMappings.entrySet()) {
            while (value - entry.getKey() >= 0) {
                value = value - entry.getKey();
                this.romanNumeral += entry.getValue();
            }
        }
    }

    private Map<Integer, String> generateNumeralMappings() {
        Map<Integer, String> mappings = new LinkedHashMap<>();
        mappings.put(1000, "M");
        mappings.put(900, "CM");
        mappings.put(500, "D");
        mappings.put(400, "CD");
        mappings.put(100, "C");
        mappings.put(90, "XC");
        mappings.put(50, "L");
        mappings.put(40, "XL");
        mappings.put(10, "X");
        mappings.put(9, "IX");
        mappings.put(5, "V");
        mappings.put(4, "IV");
        mappings.put(1, "I");
        return mappings;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}