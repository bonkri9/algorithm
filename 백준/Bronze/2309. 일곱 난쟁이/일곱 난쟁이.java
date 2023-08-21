import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] minimi = new int[9]; // 난쟁이 9명 모두 배열에 받음
		for (int i = 0; i < minimi.length; i++) {
			minimi[i] = sc.nextInt();
		}

		Arrays.sort(minimi); // 오름차순 정렬
		int sumOfAll = 0;
		for (int i = 0; i < minimi.length; i++) { // 9명의 키 총합을 계산
			sumOfAll += minimi[i];
		}
		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < minimi.length; i++) { // 9명 중에 두명을 뺀 값이 100인 조합을 찾음
			for (int j = 0; j < minimi.length; j++) {
				if (i < j && sumOfAll - minimi[i] - minimi[j] == 100) {
					idx1 = i; // 뺀 두명의 인덱스를 저장
					idx2 = j;
				}
			}
		}

		int[] real = new int[9]; // 뺀 두명 빼고 7명을 real 배열에 삽입
		for (int i = 0; i < minimi.length; i++) {
			if (idx1 == i || idx2 == i) {
				continue;
			} else {
				real[i] = minimi[i];
			}
		}

		for (int i = 0; i < real.length; i++) { // 0이 아닌 숫자가 있는 것만 출력
			if (real[i] == 0) {
				continue;
			} else {
				System.out.println(real[i]);
			}
		}
	}

}