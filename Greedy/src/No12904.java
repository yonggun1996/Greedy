package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문자열 s에서 붙여보는 방법이 아닌 t에서 분해해보는 방식
t에서 분해를 할 때 끝 부분이 'A'인 경우 그냥 뺀다
'B'인 경우 뺀 다음 문자열을 뒤집어준다
주로 StringBuilder를 이용해 문제 해결
 */

public class No12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        StringBuilder sb = new StringBuilder(t);
        while(s.length() < sb.length()){
            if(sb.charAt(sb.length() - 1) == 'A'){
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        if(s.equals(sb.toString())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
