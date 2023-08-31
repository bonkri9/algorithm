import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] Arr;
	static int[] sortedArr;
	static int cnt = 0;
	static int K;
	static int ans;
	
	public static void mergeSort(int arr[], int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int arr[], int left, int mid, int right) {
		int L = left;
		int R = mid +1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];
		}
		
		while(L <= mid) {
			sortedArr[idx++] = arr[L++];
		}
		while(R <= right) {
			sortedArr[idx++] = arr[R++];
		}
		
		for(int i = left; i<= right; i++) {
			arr[i] = sortedArr[i];
			cnt++;
			if(cnt == K) {
				ans = arr[i];
				return;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			Arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sortedArr = new int[Arr.length];
		ans = -1;
		mergeSort(Arr, 0, Arr.length-1);
		
		
		bw.write(Integer.toString(ans));
		bw.close();
		br.close();
	}
}
