import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Gas_stationBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long[] city = new long[N];
		long[] km = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) {
			km[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) {
			km[i] = Long.parseLong(st.nextToken());
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
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

}
