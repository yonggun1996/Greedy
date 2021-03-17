import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MeetingRoom {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int meetingcount = in.nextInt();
		int[][] meetingtime = new int[meetingcount][2];
		
		for(int i = 0; i < meetingcount; i++) {
			/*String time = in.next();
			
			StringTokenizer st = new StringTokenizer(time);
			
			while(st.hasMoreTokens()) {
				meetingtime[i][0] = Integer.parseInt(st.nextToken());
				meetingtime[i][1] = Integer.parseInt(st.nextToken());
			}*/
			meetingtime[i][0] = in.nextInt();
			meetingtime[i][1] = in.nextInt();
		}
		
		Arrays.sort(meetingtime, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		
		for(int i = 0; i < meetingcount; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(meetingtime[i][j] + " ");
			}
			System.out.println();
		}
		
		int i = 0;
		int count = 1;
		while(i < meetingcount) {
			int starttime = meetingtime[i][0];
			int endtime = meetingtime[i][1];
			
			i++;
			for(; i < meetingcount; i++) {
				if(meetingtime[i][0] >= endtime) {
					starttime = meetingtime[i][0];
					endtime = meetingtime[i][1];
					count++;
				}
			}
			
			
		}
		
		System.out.println(count);
	}

}
