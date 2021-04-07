import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class ForgetbracketBuffer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> number = new LinkedList<Integer>();
		LinkedList<Character> operator = new LinkedList<Character>();
		
		String expression = br.readLine();
		String number_str = "";
		for(int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				number_str += expression.charAt(i);
			}else {
				operator.add(expression.charAt(i));
				number.add(Integer.parseInt(number_str));
				number_str = "";
			}
		}
		
		if(!number_str.equals("")) {
			number.add(Integer.parseInt(number_str));
		}
		
		for(int i = 0; i < operator.size(); i++) {
			if(operator.get(i) == '+') {
				int sum = number.get(i) + number.get(i + 1);
				number.remove(i + 1);
				number.remove(i);
				number.add(i, sum);
				operator.remove(i);
				i--;
			}
		}
		
		int num = number.get(0);
		for(int i = 1; i < number.size(); i++) {
			num -= number.get(i);
		}
		
		bw.write(String.valueOf(num));
		bw.flush();
		bw.close();
	}

}
