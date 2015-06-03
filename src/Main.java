import java.util.*;
/**
 * Решить задачу подсчета повторяющихся элементов в массиве с
 * помощью HashMap.
*/

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Человек1");
		map.put(2, "Человек2");
		map.put(3, "Человек3");
		map.put(4, "Человек3");
		map.put(7, "Человек3");
		map.put(6, "Человек3");
		map.put(7, "Человек3");

		int[] list = new int[map.size()];
		Set<Map.Entry<Integer, String>> valueMap = map.entrySet();

		Set<Integer> set = map.keySet(); // создан сет ключей
		int i = 0;
		for (Integer key : set) {
			int k = 0;
			for (Map.Entry<Integer, String> entry : valueMap)// по всему массиву map
			{
				if (key == entry.getKey() && map.get(key).equals(entry.getValue()))
				{
					k++;
				}
			}
			list[i] = k;
			i++;
		}

		System.out.println(map.size());
	}

}
