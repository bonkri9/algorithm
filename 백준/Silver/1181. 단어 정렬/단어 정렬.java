
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> strSet = new HashSet<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			strSet.add(str);
		}
		
		List<String> list = new ArrayList<>(strSet);
		
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (a.length() == b.length()) ? a.compareTo(b) : a.length() - b.length();
			}
		});
		
		for(String str : list) {
			System.out.println(str);
		}
	}

}
