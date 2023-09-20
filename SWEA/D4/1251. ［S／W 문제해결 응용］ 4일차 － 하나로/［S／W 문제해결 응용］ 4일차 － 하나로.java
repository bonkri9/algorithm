import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x, y;
	double fDistance;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(double fDistance) {
		x = 0;
		y = 0;
		this.fDistance = fDistance;
	}

	@Override
	public int compareTo(Point o) {
		return (int) (this.fDistance - o.fDistance);
	}

}

public class Solution {

	static int[] arrSet;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bReader.readLine());

		// 테스트 케이스 시작
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(bReader.readLine());

			Point[] arrIsland = new Point[N];

			for (int i = 0; i < N; i++)
				arrIsland[i] = new Point();

			// x입력
			StringTokenizer st = new StringTokenizer(bReader.readLine());
			StringTokenizer st2 = new StringTokenizer(bReader.readLine());

			for (int i = 0; i < N; i++) {
				arrIsland[i].x = Integer.parseInt(st.nextToken());
				arrIsland[i].y = Integer.parseInt(st2.nextToken());
			}

			double E = Double.parseDouble(bReader.readLine());

			// 각 정점 별 거리 계산
			double[][] arrList = new double[N * (N - 1) / 2][3];

			int nIndex = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N; j++) {
					if (i == j)
						continue;

					double fDistance = getdistance(arrIsland[i], arrIsland[j]);

					arrList[nIndex][0] = i;
					arrList[nIndex][1] = j;
					arrList[nIndex++][2] = fDistance;
				}
			}
			//System.out.println(nIndex + "/" + (N * (N - 1) / 2));
			// 크루스칼 1단계 : 간선을 정렬(오름차순)
			Arrays.sort(arrList, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					// TODO Auto-generated method stub
					return Double.compare(o1[2], o2[2]);
				}
			});

//			for (int i = 0; i < arrList.length; i++)
//				System.out.println(Arrays.toString(arrList[i]));

			// 2. 최초 집합 설정해주고
			arrSet = new int[N];
			for (int i = 0; i < N; i++) {
				arrSet[i] = i;
			}

			// 2-2 검사하면서 뽑아
			double fBridge = 0; // 최소 비용을 뽑자
			int pick = 0; // 뽑은 간선의 수

			for (int i = 0; i < arrList.length; i++) {
				// i번째 간선을 이용하여 두개의 정점을 가지고 처리하겠따아

				int nFirstNum = (int) arrList[i][0];
				int nSecondNum = (int) arrList[i][1];

				int px = findset(nFirstNum);
				int py = findset(nSecondNum);

				if (px != py) {
					// It's not a cycle
					// union
					union(px, py);
					fBridge += E * arrList[i][2] * arrList[i][2];
					pick++;
				}

				if (pick == N - 1)
					break;
			}

			long lResult = Math.round(fBridge);

			bWriter.write("#" + t + " " + lResult);
			bWriter.write("\n");
			bWriter.flush();
		}
		bWriter.close();
	}

	public static void union(int x, int y) {
		arrSet[y] = arrSet[x];
	}

	public static int findset(int p) {
		if (p != arrSet[p])
			arrSet[p] = findset(arrSet[p]);

		return arrSet[p];
	}

	// 점과 점 사이의 거리
	public static double getdistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}
}
