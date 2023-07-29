import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];		
		int A=0;
		int B=0;
		int max =0;
        
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
                arr[i][j] = sc.nextInt();
				if(max<arr[i][j]) {
					max = arr[i][j];
					A = i+1;
					B = j+1;
				}else if(max==0) {
					A = 1;
					B = 1;
				}
				
			}
		}
		System.out.println(max);
		System.out.println(A+" "+B);
		
	}

}