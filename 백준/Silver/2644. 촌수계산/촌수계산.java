import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] family;
	static boolean[] visit;
	static int[] depth;;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //사람 수
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //A와 B의 촌수를 구하자
		int B = Integer.parseInt(st.nextToken());
		
		family = new ArrayList[N+1];
		depth = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			family[i] = new ArrayList<>();
		}
		
		M = Integer.parseInt(br.readLine()); //부모자식 간 관계 개수
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); //부모번호
			int Y = Integer.parseInt(st.nextToken()); //자식번호
			
			family[X].add(Y);
			family[Y].add(X);
		}//입력 끝
		
		depth[A] = 0;
		queue.add(A);
		visit[A] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(curr == B) {
				break;
			}
			
			for(int i=0;i<family[curr].size();i++) {
				int now = family[curr].get(i);
				if(!visit[now] ) {
					depth[now] = depth[curr]+1;
					visit[now] = true;
					queue.add(now);
				}
			}
		}
		
		br.close();
		if(depth[B] ==0) {
			bw.append("-1");
		}else {
			bw.append(String.valueOf(depth[B]));
		}
		bw.flush();
		bw.close();
	}//main
	
}