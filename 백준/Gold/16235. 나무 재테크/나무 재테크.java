
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// N x N 크기의 땅
	// (r,c) 위치 r과 c는 1부터 시작
	// 가장 처음에 양분은 모든 칸에 5만큼 존재
	// M개의 나무 구매
	// 1x1 크기 칸에 여러개 나무 심기 가능
	// 봄 - 나무가 자신의 나이만큼 양분 먹고 나이 1증가, 나이가 어린 나무부터 양분 섭취 양분 부족시 즉사
	// 여름 - 봄에 죽은 나무가 양분으로 변함, 나무 죽으면 나이/2 만큼 양분 추가, 소수점 버림
	// 가음 - 나무 번식, 나무 나이가 5의 배수여야 번식 가능, 인접한 8개 칸에 나이 1인 나무 생김, 경계 벗어난 곳은 안 생김
	// 겨울 - A[r][c]만큼 양분 추가
	// K년 지난 후 살아있는 나무 개수 출력
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // NxN크기의 땅
		int M = Integer.parseInt(st.nextToken()); // 구매한 나무 개수
		int K = Integer.parseInt(st.nextToken()); // K년 후

		int[][] feed = new int[N + 1][N + 1];
		int[][] A = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				feed[i][j] = 5;
			}
		}

		Deque<Tree> tree = new LinkedList<>();

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(r, c, age));
		} // 입력 끝

		int year = 0;
		while (year < K) {
			Deque<Tree> deadTree = new LinkedList<>();
			Queue<Tree> tmp = new LinkedList<Tree>();
			
			//spring
			for (int i = 0; i < tree.size();) {
				Tree curr = tree.poll();
				if (feed[curr.r][curr.c] >= curr.age) {
					feed[curr.r][curr.c] -= curr.age;
					curr.age++;
					i++;
					tree.add(curr);
				} else {
					deadTree.add(curr);
				}
			} // spring

			//summer
//			for (int i = 0; i < deadTree.size(); i++) {
//				Tree curr = deadTree.poll();
//				feed[curr.r][curr.c] += curr.age / 2;
//			} // summer
			
			for (Tree trees : deadTree) {
				feed[trees.r][trees.c] += trees.age / 2;
			} // summer
			
			//fall
			for (Tree tmpTree : tree) {
				if (tmpTree.age % 5 == 0) {
					tmp.add(tmpTree);
				}
			}

			while (!tmp.isEmpty()) {
				Tree curr = tmp.poll();
				for (int i = 0; i < 8; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
						tree.addFirst(new Tree(nr, nc, 1));
					}

				}
			}//fall
			
			//winter
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					feed[i][j] += A[i][j];
				}
			}//winter

			year++;
		}

		br.close();
		bw.append(String.valueOf(tree.size()));
		bw.flush();
		bw.close();
	}

}

class Tree implements Comparable<Tree> {
	int r, c, age;

	public Tree(int r, int c, int age) {
		super();
		this.r = r;
		this.c = c;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
}
