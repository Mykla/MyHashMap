import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 02.06.2015.
 */
public class MainTest {
    public static void main(String[] args) {
        Map <Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Человек1");
        map.put(2, "Человек2");
        map.put(3, "Человек3");
        System.out.println(map.get(1) + " , " + map.get(2));

        // 1.
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry : set)
            System.out.println(entry.getKey() + " = " + entry.getValue());

        // 2.
        Set<Integer> set2 = map.keySet();
        for (Integer key : set2)
            System.out.println(map.get(key));

        // 3.
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
