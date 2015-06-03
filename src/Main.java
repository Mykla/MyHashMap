
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap2<String, String> h = new HashMap2<String, String>();
		
		h.put("1", "value1");
		h.put("2", "value2");
		
		System.out.println(h.size());
		System.out.println(h.get("1"));
		System.out.println(h.get("2"));
	}

}
