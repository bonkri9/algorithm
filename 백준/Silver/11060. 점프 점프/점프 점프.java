import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Jumper {
	int nPoint;
	int nCount;
	public Jumper(int nPoint, int nCount) {
		super();
		this.nPoint = nPoint;
		this.nCount = nCount;
	}
	
}

public class Main {
	static int[] narrMaze;
	static int[] narrDP;
	static boolean[] barrVisited;
	static int nMin;
	public static void main(String[] args) throws IOException {
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bReader.readLine()); // 정점의 개수
		StringTokenizer st = new StringTokenizer(bReader.readLine());
		
		narrMaze = new int[N];
		narrDP = new int[N];
		barrVisited = new boolean[N];
		Arrays.fill(narrDP, Integer.MAX_VALUE);
		nMin = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N; i++) 
			narrMaze[i] = Integer.parseInt(st.nextToken());
		
		if(N== 1)
			bWriter.write("0");
		else
			bWriter.write(String.valueOf(BFS()));

		bWriter.flush();
		bWriter.close();
	}
	
	private static int BFS() {
		// TODO Auto-generated method stub
		Queue<Jumper> queueBFS = new LinkedList<Jumper>();
		queueBFS.add(new Jumper(0, 0));
		
		while(!queueBFS.isEmpty()) {
			Jumper jumper = queueBFS.poll();
			
			if(jumper.nPoint > narrMaze.length-1)
				continue;

			for(int i = 1 ; i <= narrMaze[jumper.nPoint]; i++) {
				
				
				// 배열 크기 예외처리
				if(jumper.nPoint + i > narrMaze.length-1)
					continue;
				int nNextPoint = jumper.nPoint + i;
				
				if(nNextPoint == narrMaze.length-1) {
					if(nMin > jumper.nCount+1)
						nMin = jumper.nCount+1;
				}
				// 
				if(nNextPoint > narrMaze.length-1)
					continue;
				
				// DP 최소 경로만
				if(narrDP[nNextPoint] >= jumper.nCount+1)
					narrDP[nNextPoint] = jumper.nCount+1;
				else
					continue;
				
				
				// 방문처리
				if(barrVisited[nNextPoint])
					continue;
				else
					barrVisited[nNextPoint] = true;
				
				queueBFS.add(new Jumper(nNextPoint, jumper.nCount+1));
				
			}
	
		}
		
		if(nMin == Integer.MAX_VALUE)
			nMin = -1;
		
		return nMin;
	}

	
}