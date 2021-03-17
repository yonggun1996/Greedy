import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CoinBuffer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int coincount = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[coincount];
		
		for(int i = 0; i < coincount; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = coincount - 1;
		int count = 0;
		while(money != 0) {
			if(coin[i] <= money) {
				count += (money / coin[i]);
				money = money % coin[i];
			}
			
			i--;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

}
