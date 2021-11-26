package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n == 1){//높이가 1이면 어디든 이동할 수 없다.
            System.out.println(1);
        }else if(n == 2){//높이가 2이면 2,3번 조건만 쓸 수 있기 때문에 최대 4번 이동이 가능하다
            if(m >= 7){//너비가 7 이상이어도 1,4번 조건을 이용할 수 없기 때문에 최대 4개의 칸 방문 가능
                System.out.println(4);
            }else{//그 외의 경우는 오른쪽 2칸 갈 때 최대로 갈 수 있는 방문칸을 춫력한다
                System.out.println((m + 1) / 2);
            }
        }else{//높이가 2보다 큰 경우
            if(m >= 7){//너비가 7보다 크면 2,3번 조건을 하나씩, 나머지는 1,4번 조건대로 움직인다.
                System.out.println((m - 5) + 3);
            }else{//4가지 조건을 다 적용할 수 없는 경우
                if(m >= 4){//너비가 4보다 크면 4개의 칸 이상은 갈 수 없다
                    System.out.println(4);
                }else{//그 외에는 오른쪽으로 1씩 이동하면 되기 때문에 m을 그대로 출력
                    System.out.println(m);
                }
            }
        }
    }
}