import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 03.06.2015.
 */
public class SameElementsCounter <E> {
    private Map<E, Integer> map = new HashMap<E, Integer>();

    public SameElementsCounter(E [] array) {
        for (E elem : array) {
            map.put(elem, map.containsKey(elem) ? map.get(elem)+1 : 1);
        }
    }

    public Integer getCount(E elem) {
        return map.get(elem);
    }
}
