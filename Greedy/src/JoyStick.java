
public class JoyStick {

	static StringBuilder sb1;
	
	//�� ���κп��� ���������� �̵��� ���� �������� �ʴ´�
	public static void main(String[] args) {
		JoyStick j = new JoyStick();
		String name = "CANAAAAANAN";
		System.out.println(j.solution(name));
	}
	
	public int solution(String name) {
		JoyStick j = new JoyStick();
		sb1 = new StringBuilder();//name�� StringBuilder��
		StringBuilder sb2 = new StringBuilder();//�� ������ String�� ��� A�� ����
		
		for(int i = 0; i < name.length(); i++) {
			sb1.append(name.charAt(i));
			sb2.append('A');
		}
		
		int count = 0;
		if(name.charAt(0) != 'A') {//ù ��° ���ڰ� A�� �ƴϸ� �ٲ�� �Ѵ�
			int alphebetcount = j.checkalphabet(name.charAt(0));
			count += alphebetcount;
			sb1.setCharAt(0, 'A');
		}
		
		int index = 0;
		while(!sb1.toString().equals(sb2.toString())) {
			int leftcount = j.left_rotate(sb1.toString(), index);//�������� �̵��Ϸ��� �󸶳� �̵��ؾ� �ϴ°�
			int rightcount = j.right_rotate(sb1.toString(), index);//���������� �̵��ϸ� �󸶳� �̵��ؾ� �ϴ°�
			
			if(leftcount < rightcount) {//���� �̵��� ���� ��� �׷��� ������ ���������� �̵��ؾ� �����̾���
				count += leftcount;
				index -= leftcount;
				
				if(index < 0) {//�ε����� ���� �� 0���� �۴ٸ� �ٽ� �� �����ʺ��� ���
					index += name.length();
				}
				
				count += j.checkalphabet(name.charAt(index));
				sb1.setCharAt(index, 'A');
			}else {//������ �̵��� �� �������
				count += rightcount;
				index += rightcount;
				count += j.checkalphabet(name.charAt(index));
				sb1.setCharAt(index, 'A');
			}
		}
		
		return count;
	}
	
	public int left_rotate(String name, int index) {//�������� �̵��� ����
		//�� ���ʿ��� �������� �̵��ϸ� �� ������ ���ڸ� Ž���Ѵ�
		int move = 0;
		while(true) {
			if(index == 0) {
				index = name.length() - 1;
				move++;
			}else {
				index--;
				move++;
			}
			
			if(name.charAt(index) != 'A') {
				return move;
			}
			
		}
	}
	
	public int right_rotate(String name, int index) {//������ �̵��� ����
		//�� �����ʿ��� ���������� �̵��� �� ���ٴ°� �˾ƾ� �Ѵ�
		int move = 0;
		while(true) {
			if(index < name.length() - 1) {
				index++;
				move++;
			}
			if(name.charAt(index) != 'A') {//�ٲ� �κ��� �ִٸ� �̵�Ƚ���� ��ȯ
				return move;
			}
			
			if(index == name.length() - 1) {//�� ���������� �԰� �ٲ� �ʿ䰡 ���� ���ڶ�� int�� �ִ��� ��ȯ
				return 2147483647;
			}
		}
	}
	
	public int checkalphabet(char c) {//���ĺ��� A�� �ٲٷ��� �󸶳� �ٲ�� �ϴ��� ��ȯ�ϴ� �Լ�
		int count = 0;
		if(c >= 'B' && c <= 'M') {
			count += c - 'A';
		}else if(c >= 'O' && c <= 'Z') {
			count += 'Z' - c + 1;
		}else {
			count += 13;
		}
		
		return count;
	}

}
