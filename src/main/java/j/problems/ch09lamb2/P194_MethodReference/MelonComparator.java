package j.problems.ch09lamb2.P194_MethodReference;

import java.util.Comparator;

public class MelonComparator implements Comparator {

    @Override
    public int compare(Object m1, Object m2) {
        return Integer.compare(((Melon) m1).getWeight(), ((Melon) m2).getWeight());
    }

}
