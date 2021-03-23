import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] time = new int[n];
		
		for(int i = 0; i < n; i++) {
			time[i] = in.nextInt();
		}
		
		Arrays.sort(time);
		
		int answer = 0;
		int front_time = n;
		for(int i = 0; i < n; i++) {
			answer += time[i] * front_time;
			front_time--;
		}
		
		System.out.println(answer);
	}

}
