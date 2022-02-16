package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
완전탐색 알고리즘을 생각했지만 전구가 최대 100000개기 때문에 시간초과 or 메모리초과를 부를 수 있다.
그리디 알고리즘으로 해결한 문제
도움이 된 블로그 : https://staticvoidlife.tistory.com/143
상태가 다른 전구가 생길 경우 오른쪽 스위치를 건드려 전구의 상태를 바꾼다
바꾸는 알고리즘을 거쳤을 때 원하는 상태로 바뀌지 못했으면 바꿀 수 없는 것
0번 스위치를 누른 & 안누른 상태에서 시작을 해서 값을 찾아내고 최소값을 출력한다
 */

public class No2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int search1 = search(s1.toCharArray(), s2.toCharArray(), 0);//맨 앞 전구를 키지 않고 원하는 전구대로 나올 수 있는 경우

        //맨 앞 전구를 키는 코드
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(c1[0] == '0') {
            c1[0] = '1';
        }else{
            c1[0] = '0';
        }

        if(c1[1] == '0') {
            c1[1] = '1';
        }else{
            c1[1] = '0';
        }

        //맨 앞 전구를 키고 스위치를 키는 알고리즘을 돌리는 결과
        int search2 = search(c1, c2, 1);

        if(search1 == -1 && search2 == -1){//둘 다 답이 안나온 경우
            System.out.println(-1);
        }else if(search1 != -1 && search2 == -1){//search1이 답이 나온 경우
            System.out.println(search1);
        }else if(search1 == -1 && search2 != -1){//search2가 답이 나온 경우
            System.out.println(search2);
        }else{//둘 다 답이 나온 경우는 둘 중 최소값을 출력
            System.out.println(Math.min(search1, search2));
        }
    }

    //맨 앞에서 부터 스위치를 켜보는 동작을 가진 메서드
    static int search(char[] c1, char[] c2, int count){
        for(int i = 0; i < c1.length - 1; i++){
            if(c1[i] != c2[i]){//원하는 불빛과 다른 경우
                count++;//우선 count를 증가

                //현재 전구를 포함해 3개의 전구 상태를 바꾼다
                for(int j = i; j < i + 3 && j < c1.length; j++){
                    //0일 경우 1로, 1일 경우 0으로
                    if(c1[j] == '0'){
                        c1[j] = '1';
                    }else{
                        c1[j] = '0';
                    }
                }
            }
        }

        //마지막 값이 다르다는 것은 상태를 바꿀 수 없다는 것으로 -1 반환
        if(c1[c1.length - 1] != c2[c1.length - 1]){
            return -1;
        }

        //상태를 바꾸는데 성공했으므로 스위치를 누른 횟수 반환
        return count;
    }
}
