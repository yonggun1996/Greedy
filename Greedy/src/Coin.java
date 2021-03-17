import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int coincount = in.nextInt();
		int money = in.nextInt();
		
		int[] coin = new int[coincount];
		
		for(int i = 0; i < coincount; i++) {
			coin[i] = in.nextInt();
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
		
		System.out.println(count);
	}

}
