import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<>();
		map.put("STRAWBERRY", 0);
		map.put("BANANA", 0);
		map.put("LIME", 0);
		map.put("PLUM", 0);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String fruit = sc.next();
			int card = sc.nextInt();
			if (map.containsKey(fruit)) {
				map.put(fruit, map.get(fruit) + card);
			}

		}
		String ans = "NO";
		for(String fruit : map.keySet()) {
			if(map.get(fruit)==5) {
				ans = "YES";
			}
		}
		System.out.println(ans);

	}
}