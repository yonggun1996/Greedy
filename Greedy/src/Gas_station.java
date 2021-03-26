import java.util.Scanner;

public class Gas_station {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		long[] city = new long[N];
		long[] km = new long[N];
		
		for(int i = 0; i < N - 1; i++) {
			km[i] = in.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			city[i] = in.nextInt();
		}
		
		long answer = 0;
		int now_index = 0;
		int min_index = 1;
		while(min_index < N) {
			if(min_index == N - 1) {
				for(int i = now_index; i < min_index; i++) {
					answer += km[i] * city[now_index];
				}
				break;
			}
			
			if(city[now_index] > city[min_index]) {
				for(int i = now_index; i < min_index; i++) {
					answer += km[i] * city[now_index];
				}
				now_index = min_index;
				min_index++;
			}else {
				min_index++;
			}
		}
		
		System.out.println(answer);
	}
	
}
