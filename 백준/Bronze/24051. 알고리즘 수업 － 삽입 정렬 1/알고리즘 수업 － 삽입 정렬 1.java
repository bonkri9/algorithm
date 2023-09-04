import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int cnt;
	static int K;
	
	static void insertionSort() {
		for (int i=1; i<arr.length; i++) {
			
			int key = arr[i];
			
			int j = i-1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
				cnt++;
				
				if (cnt == K) {
					System.out.println(arr[j+1]);
				}
			}
			
			if (arr[j+1] != key) {
				arr[j+1] = key;
				cnt++;
			}

			if (cnt == K) {
				System.out.println(arr[j+1]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N];
		cnt = 0;
		
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		insertionSort();
		
		if (cnt < K) {
			System.out.println(-1);
		}
	}
}