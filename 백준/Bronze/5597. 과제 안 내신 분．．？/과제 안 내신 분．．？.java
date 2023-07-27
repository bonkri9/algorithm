
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[30];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = i+1;
		}
		
		for(int j=0; j<arr.length-2;j++) {
			int num = Integer.parseInt(br.readLine());
			for(int k=0;k<arr.length;k++) {
				if(arr[k]==num)
					arr[k]=0;
			}
		}
		
		for(int l =0; l<arr.length;l++) {
			if(arr[l]!=0)
				System.out.println(arr[l]);
		}
	}
}
