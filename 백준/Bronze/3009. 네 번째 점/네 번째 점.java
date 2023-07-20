import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] xy1 = {sc.nextInt(),sc.nextInt()};
		int[] xy2 = {sc.nextInt(),sc.nextInt()};
		int[] xy3 = {sc.nextInt(),sc.nextInt()};
		
		sc.close();
		int a;
		int b;
		
		if(xy1[0] == xy2[0]) 
			a = xy3[0];
		else if(xy2[0] == xy3[0])
			a = xy1[0];
		else a = xy2[0];
		
		if(xy1[1] == xy2[1])
			b = xy3[1];
		else if(xy2[1] == xy3[1])
			b = xy1[1];
		else b = xy2[1];
		
		System.out.println(a+" "+b);
		
	}

}