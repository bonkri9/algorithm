import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		int sumOfDay = 0;
		
		for(int i=1; i<=month; i++) {
			if(i==2||i==4||i==6||i==8||i==9||i==11) {
				sumOfDay += 31;
			} else if(i==5||i==7||i==10||i==12) {
				sumOfDay += 30;
			} else if(i==3) {
				sumOfDay += 28;
			} else {
				sumOfDay += 0;
			}
		}		//System.out.println(sumOfDay);
		
		sumOfDay += day;
		
		if(sumOfDay%7==0) System.out.println("SUN");
		else if(sumOfDay%7==1) System.out.println("MON");
		else if(sumOfDay%7==2) System.out.println("TUE");
		else if(sumOfDay%7==3) System.out.println("WED");
		else if(sumOfDay%7==4) System.out.println("THU");
		else if(sumOfDay%7==5) System.out.println("FRI");
		else System.out.println("SAT");
		
	}
}