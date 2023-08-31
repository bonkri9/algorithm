import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// n과 m이 주어졌을 때, n개의 노드로 이루어져있고
		// m개의 리프로 이뤄진 트리를 만들어라.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 노드의 수
		int m = sc.nextInt(); // 리프의 수
		
		int j = 1; // 이어지는 노드들을 모두 표현하기 위한 카운터
		
		for (int i=0; i<n-1; i++) { // n-1줄까지 반복
			if (m > 2 && i==2) { // 맨 위와 맨 아래 노드는 리프노드이고, 1번 노드에 리프 노드를 붙이겠다.
				int tmp = m-2; // 와일문을 나가기 위한 tmp, 맨 위와 아래 노드를 제외한 리프노드의 수이다.
				while (tmp > 0) { // 리프 노드 추가가 필요 없을때까지
					System.out.println((i-1)+" "+j); // 리프노드를 1번 노드에 붙여준다.
					tmp--;
					j++;
				} 	
			} else {
				System.out.println(i+" "+j); // 아닐 경우 일반 노드를 출력
				j++;
			}
		}
	}
}