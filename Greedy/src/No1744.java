package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1744번 문제 : 한 수열이 주어질 때 더 큰 값을 구하기 위해
곱하기를 섞는데 이 연산을 했을 때 가장 큰 값은?
리스트를 음수와 양수로 나눈다.
그 후 정렬 후 인접한 두 수 끼리 곱한 후 더하면 된다.
단 0이 있으면 곱하는 값 보다 더하는 값이 클 수 있기 때문에
if문을 통해 그 중 큰 연산을 해 스택에 넣고 스택의 값들을 모두 더한다
음수 리스트들을 더한 값과 양수 리스트들을 더한 값을 또 더해 답을 구한다
 */

public class No1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){//입력될 수가 하나인 경우 연산이 필요 없기 때문에 입력값을 바로 출력한다
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);
            return;
        }

        ArrayList<Integer> plusnum_List = new ArrayList<>();//양수를 담는 리스트
        ArrayList<Integer> minusnum_List = new ArrayList<>();//음수와 0을 담는 리스트

        //양수롸 음수를 각 리스트에 나눠담는 과정
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0){
                minusnum_List.add(num);
            }else{
                plusnum_List.add(num);
            }
        }

        int num1 = get_Num(plusnum_List);//양수끼리의 연산 결과
        int num2 = get_Num(minusnum_List);//음수끼리의 연산 결과

        System.out.println(num1 + num2);
    }

    static int get_Num(ArrayList<Integer> list){
        if(list.size() == 0) return 0;//수가 없으면 0 출력
        if(list.size() == 1) return list.get(0);//수가 하나면 연산할 필요가 없기 때문에 숫자 출력

        //절대값을 기준으로 내림차순 정렬
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < list.size(); i+=2){
            if(i == list.size() - 1) {//i가 마지막 인덱스면 연산을 거치지 않고 스택에 삽입
                stack.push(list.get(i));
                continue;
            }

            //인접한 수 2개를 추출
            int n1 = list.get(i);
            int n2 = list.get(i + 1);

            //곱하기 값이 크면 스택에 곱한 값을 삽입
            //더하기 값으 크면 스택에 더한 값을 삽입
            if(n1 * n2 > n1 + n2){
                stack.push(n1 * n2);
            }else{
                stack.push(n1 + n2);
            }
        }

        int num = 0;
        while(!stack.isEmpty()){//스택 내 수들을 다 더한다
            num += stack.pop();
        }

        return num;
    }
}