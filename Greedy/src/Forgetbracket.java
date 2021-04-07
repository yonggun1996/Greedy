import java.util.LinkedList;
import java.util.Scanner;

public class Forgetbracket {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<Integer> number = new LinkedList<Integer>();
		LinkedList<Character> operator = new LinkedList<Character>();
		
		String expression = in.next();
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
		
		System.out.println(num);
	}

}
