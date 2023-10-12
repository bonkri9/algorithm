
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
	
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 }; //8방탐색
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // NxN크기의 땅
		int M = Integer.parseInt(st.nextToken()); // 구매한 나무 개수
		int K = Integer.parseInt(st.nextToken()); // K년 후

		int[][] feed = new int[N + 1][N + 1]; //영양분 정보가 있는 배열
		int[][] A = new int[N + 1][N + 1]; //겨울마다 추가해줄 영양분 정보가 있는 배열

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()); //겨울 추가영양분 정보 배열 입력
				feed[i][j] = 5; //초기 영양분은 5로 저장
			}
		}

		Deque<Tree> tree = new LinkedList<>(); //나중에 addFirst를 위해서 Deque를 활용

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); //행
			int c = Integer.parseInt(st.nextToken()); //열
			int age = Integer.parseInt(st.nextToken()); //나이
			tree.add(new Tree(r, c, age)); //tree 에 추가 
		} // 입력 모두 끝

		int year = 0; //햇수는 처음에 0
		
		while (year < K) { //해가 K가 될때까지 반복 실행
			Deque<Tree> deadTree = new LinkedList<>(); //죽은 나무 모음집
			Queue<Tree> tmp = new LinkedList<Tree>(); //나무 나이를 저장할 임시로 사용될 큐
			
			//spring
			for (int i = 0; i < tree.size();) { 
				Tree curr = tree.poll(); //현재 나무 정보 저장
				if (feed[curr.r][curr.c] >= curr.age) { //나무 정보를 통해 영양분 >= 현재 나무 나이라면
					feed[curr.r][curr.c] -= curr.age; //영양분 먹을 수 있으므로 영양분 흡수
					curr.age++; //나무 나이가 1증가
					i++; //if문에 올 때만 i++실행
					tree.add(curr); //새로운 나무 정보를 다시 tree에 저장
				} else {
					deadTree.add(curr); //영양분이 적어서 죽은 나무는 따로 저장 
				}
			} // spring

			
			//summer
			for (Tree trees : deadTree) { //죽은 나무 정보를 훑는다
				feed[trees.r][trees.c] += trees.age / 2; //죽은 나무의 나이의 절반을 영양분으로 추가
			} // summer
			
			//fall
			for (Tree tmpTree : tree) { //살아있는 나무를 훑는다
				if (tmpTree.age % 5 == 0) { //해당 나무 나이가 5의 배수라면
					tmp.add(tmpTree); //5의 배수인 나무를 tmp 큐에 정보를 저장
				}
			}

			while (!tmp.isEmpty()) { //5의 배수 나이를 가진 나무 정보가 들어있는 tmp를 모두 훑는다
				Tree curr = tmp.poll(); //현재 나무 정보 저장
				for (int i = 0; i < 8; i++) { //8방탐색
					int nr = curr.r + dr[i]; //행 갱신
					int nc = curr.c + dc[i]; //열 갱신
					if (nr >= 1 && nr <= N && nc >= 1 && nc <= N) { //경계범위 안에 있다면
						tree.addFirst(new Tree(nr, nc, 1)); //나무 나이가 1이니까 tree의 가장 앞에 추가시켜야한다
					}
				}
			}//fall
			
			//winter
			for (int i = 1; i < N+1; i++) { //행
				for (int j = 1; j < N+1; j++) { //열
					feed[i][j] += A[i][j]; //추가해주려는 영양분을 기존 영양분 위치에 추가해준다. 
				}
			}//winter

			year++; //햇수 1 추가
		}

		br.close();
		bw.append(String.valueOf(tree.size())); //살아있는 나무의 개수를 출력
		bw.flush();
		bw.close();
	}

}

class Tree implements Comparable<Tree> { //Tree를 한묶음으로 Deque에 저장하자
	int r, c, age; //행 r, 열 c, 나이 age

	public Tree(int r, int c, int age) { //생성자
		super();
		this.r = r;
		this.c = c;
		this.age = age;
	}

	@Override
	public int compareTo(Tree o) { //comparable을 통한 적은 나이 순으로 저장하자 
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
}
