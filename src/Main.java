import java.util.*;
/**
 * Решить задачу подсчета повторяющихся элементов в массиве с помощью HashMap.
*/

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		// исходный массив
		map.put(1, "Человек1");
		map.put(2, "Человек1");
		map.put(3, "Человек1");
		map.put(4, "Человек1");
		map.put(5, "Человек3");
		map.put(6, "Человек3");
		map.put(7, "Человек3");

		// создание коллекции уникальных значений
		Set<String> uniqueSet = new HashSet<String>();
		for (Integer key : map.keySet()) {
			uniqueSet.add(map.get(key));
		}

		// определение частоты повторов значений из коллекции uniqueSet
		List<String> list = new ArrayList<String>(map.values());
		for (String temp : uniqueSet) {
			System.out.println(temp + ": " + Collections.frequency(list, temp));
		}
	}

	}
