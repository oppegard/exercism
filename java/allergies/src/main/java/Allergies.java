import java.util.ArrayList;
import java.util.List;

public class Allergies {
    private final int allergensBitmask;
    private final List<Allergen> allergenList;

    Allergies(int allergensBitmask) {
        this.allergensBitmask = allergensBitmask;
        this.allergenList = generateList();
    }

    private List<Allergen> generateList() {
        ArrayList<Allergen> allergenList = new ArrayList<>();
        for (Allergen allergen : Allergen.values())
            if (isAllergicTo(allergen)) allergenList.add(allergen);
        return allergenList;
    }

    public List<Allergen> getList() {
        return this.allergenList;
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (allergen.getScore() & this.allergensBitmask) != 0;
    }
}