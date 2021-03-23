import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATMBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());;
		for(int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		int answer = 0;
		int front_time = n;
		for(int i = 0; i < n; i++) {
			answer += time[i] * front_time;
			front_time--;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

}
