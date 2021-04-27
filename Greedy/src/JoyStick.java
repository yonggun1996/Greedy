
public class JoyStick {

	static StringBuilder sb1;
	
	//맨 끝부분에서 오른쪽으로 이동할 때는 움직이지 않는다
	public static void main(String[] args) {
		JoyStick j = new JoyStick();
		String name = "CANAAAAANAN";
		System.out.println(j.solution(name));
	}
	
	public int solution(String name) {
		JoyStick j = new JoyStick();
		sb1 = new StringBuilder();//name을 StringBuilder로
		StringBuilder sb2 = new StringBuilder();//그 길이의 String을 모두 A로 설정
		
		for(int i = 0; i < name.length(); i++) {
			sb1.append(name.charAt(i));
			sb2.append('A');
		}
		
		int count = 0;
		if(name.charAt(0) != 'A') {//첫 번째 문자가 A가 아니면 바꿔야 한다
			int alphebetcount = j.checkalphabet(name.charAt(0));
			count += alphebetcount;
			sb1.setCharAt(0, 'A');
		}
		
		int index = 0;
		while(!sb1.toString().equals(sb2.toString())) {
			int leftcount = j.left_rotate(sb1.toString(), index);//왼쪽으로 이동하려면 얼마나 이동해야 하는가
			int rightcount = j.right_rotate(sb1.toString(), index);//오른쪽으로 이동하면 얼마나 이동해야 하는가
			
			if(leftcount < rightcount) {//왼쪽 이동이 작을 경우 그렇지 않으면 오른쪽으로 이동해야 정답이었다
				count += leftcount;
				index -= leftcount;
				
				if(index < 0) {//인덱스를 뺐을 때 0보다 작다면 다시 맨 오른쪽부터 계산
					index += name.length();
				}
				
				count += j.checkalphabet(name.charAt(index));
				sb1.setCharAt(index, 'A');
			}else {//오른쪽 이동이 더 적은경우
				count += rightcount;
				index += rightcount;
				count += j.checkalphabet(name.charAt(index));
				sb1.setCharAt(index, 'A');
			}
		}
		
		return count;
	}
	
	public int left_rotate(String name, int index) {//왼쪽으로 이동을 구현
		//맨 왼쪽에서 왼족으로 이동하면 맨 오른쪽 문자를 탐색한다
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
	
	public int right_rotate(String name, int index) {//오른쪽 이동을 구현
		//맨 오른쪽에서 오른쪽으로 이동할 수 없다는걸 알아야 한다
		int move = 0;
		while(true) {
			if(index < name.length() - 1) {
				index++;
				move++;
			}
			if(name.charAt(index) != 'A') {//바뀔 부분이 있다면 이동횟수를 반환
				return move;
			}
			
			if(index == name.length() - 1) {//맨 오른쪽으로 왔고 바꿀 필요가 없는 문자라면 int의 최댓값을 반환
				return 2147483647;
			}
		}
	}
	
	public int checkalphabet(char c) {//알파벳을 A로 바꾸려면 얼마나 바꿔야 하는지 반환하는 함수
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
