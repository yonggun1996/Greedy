package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
빵집배관을 연결하는 방법을 구하는 문제
파이프는 오른쪽 위, 오른쪽, 오른쪽 아래로 이어갈 수 있다.
맨 왼쪽부터 탐색하는데 맨 오른쪽까지 오면 count를 늘린다
순서는 0열의 행부터 아래 순으로 살피는데 아래의 데이터들이 위로 올라올 수 있도록
오른쪽 위, 오른쪽, 오른쪽 아래 순으로 살핀다.
기존에 방문한 배열은 true로 표시해 다시 방문하지 않게 하면서 세 경로중 하나라도 맞으면 바로 true를 반환해
더이상 탐색하지 않게 한다
 */

public class BreadStore {

    static int count = 0;//파이프를 연결할 횟수
    static char[][] map;//주어진 입력값을 배열로 담기위해 선언
    static boolean[][] visit;//방문 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[r][c];

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //i행 0열을 시작점으로 둔 채로 확인한다
        for(int i = 0; i < r; i++){
            search(i, 0);
        }

        System.out.println(count);

    }

    public static boolean search(int x, int y){
        visit[x][y] = true;//방문 여부 체크
        if(y == map[0].length - 1){//마지막 열까지 왔으면 방문횟수 체크
            count++;
            return true;
        }else{
            //길이 개척이 되면 바로 return을 해 하나의 행에 하나의 경로만 살핀다
            if(x > 0 && map[x - 1][y + 1] == '.' && !visit[x - 1][y + 1]){//오른쪽 위로 갈 수 있다면
                if(search(x - 1, y + 1)){
                    return true;
                }
            }

            if(map[x][y + 1] == '.' && !visit[x][y + 1]){//오른쪽으로 갈 수 있다면
                if(search(x, y + 1)){
                    return true;
                }
            }

            if(x < map.length - 1 && map[x + 1][y + 1] == '.' && !visit[x + 1][y + 1]){//오른쪽 아래로 갈 수 있다면
                if(search(x + 1, y + 1)){
                    return true;
                }
            }

        }

        return false;
    }

}
