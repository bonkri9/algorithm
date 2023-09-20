import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] narrSet;
	public static void main(String[] args) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bReader.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int[][] narr = new int[E][3];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(bReader.readLine());
			narr[i][0] = Integer.parseInt(st.nextToken())-1;
			narr[i][1] = Integer.parseInt(st.nextToken())-1;
			narr[i][2] = Integer.parseInt(st.nextToken());
			
		}

		// 1. 오름차순 정렬하구
		Arrays.sort(narr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
			
		});
		
		// 2.집합 만들어주공
		narrSet = new int[V];
		for(int i = 0; i < narrSet.length; i++)
			narrSet[i] = i;
		
		// 2.1 가중치가 낮은 노드부터 연결해주자
		// 동일한 집합내에 있으면 안되니까 연결 금지이
		int nConnect = 0;
		int nWeight = 0;
		
		for(int i = 0; i < E; i++) {
			
			int nFirstHead = find(narr[i][0]);
			int nSecondHead = find(narr[i][1]);
			
			// 같은 집합 아니면 연결해주자
			if(nFirstHead != nSecondHead) {
				union(nFirstHead, nSecondHead);
				nConnect++;
				nWeight += narr[i][2];
			}
			// 이것이 최소 스패팅 트리이다.
			if(nConnect == V-1)
				break;
		}


		bWriter.write(String.valueOf(nWeight));

		bWriter.flush();
		bWriter.close();
	}

	private static void union(int nFirstHead, int nSecondHead) {
		narrSet[nSecondHead] = nFirstHead;
	}

	static int find(int x) {
		if(x != narrSet[x])
			narrSet[x] = find(narrSet[x]);
		return narrSet[x];
	}
}