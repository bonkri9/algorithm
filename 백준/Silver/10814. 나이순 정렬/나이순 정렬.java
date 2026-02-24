
import java.io.*;
import java.util.*;

public class Main {
	
	static class Member {
		int age;
		String name;
		
		Member(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Member> list = new ArrayList<>();
		StringTokenizer st;
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Member(age, name));
		}
		
		Collections.sort(list, (a, b) -> a.age - b.age);
		
		for(Member m : list) {
			System.out.println(m.age + " " + m.name);
		}
	}

}
