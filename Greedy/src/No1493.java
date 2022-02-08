package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1493 {
    static int[][] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int cm = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            arr[cm][0] = 1 << cm;
            arr[cm][1] = count;
        }

        div_Cube(length, width, height);
        System.out.println(answer);
    }

    static void div_Cube(int l, int w, int h){
        int min = Math.min(Math.min(l, w), h);
        if(min == 0) return;

        int idx = getLog(min, 2);
        for(; idx >= 0; idx--){
            if(idx >= arr.length) continue;

            if(arr[idx][1] > 0 && min >= arr[idx][0]){
                break;
            }
        }

        if(idx == -1){
            System.out.println("-1");
            System.exit(0);
        }

        arr[idx][1]--;
        answer++;

        div_Cube(l, w - arr[idx][0], h);
        div_Cube(l - arr[idx][0], arr[idx][0], h);
        div_Cube(arr[idx][0], arr[idx][0], h - arr[idx][0]);
    }

    static int getLog(double x, double base){
        return (int) (Math.log10(x) / Math.log10(base));
    }
}
