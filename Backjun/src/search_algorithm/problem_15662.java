package search_algorithm;

//톱니 바퀴(2)
import java.util.*;
import java.io.*;

public class problem_15662 {
	static int [] gear;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		gear = new int[N];
		visited = new boolean[N];
		for(int i =0 ; i < N ; i++) {
			gear[i] = Integer.parseInt(br.readLine(),2);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) -1;
			int rotate = Integer.parseInt(st.nextToken());
			
			moveGear(num,rotate);
			Arrays.fill(visited, false);
		}
		
		int result = 0;
		for(int i =0 ; i < N ; i++) {
			if((gear[i] & 1<<7) == 1<<7)
				result++;
		}
		System.out.println(result);
	}
	
	private static void moveGear(int cur, int curRotate) {
		int left = cur -1, right = cur +1;
		
		visited[cur] = true;
		//범위 내에 존재 한다면
		if(left >= 0 && !visited[left]) {
			//서로 마주보는 부분이 다르면
			int lb = Integer.bitCount((gear[left] & 1<<5));
			int cb = Integer.bitCount(gear[cur] & 1<<1);
			if(lb != cb) {
				moveGear(left,curRotate*-1);
			}
		}
		
		if(right < gear.length && !visited[right]) {
			int rb = Integer.bitCount(gear[right] & 1<<1);
			int cb = Integer.bitCount(gear[cur] & 1<<5);
			if(rb != cb) {
				moveGear(right,curRotate*-1);
			}
		}
		
		rotateGear(cur,curRotate);
	}
	
	private static void rotateGear(int cur, int curRotate) {
		if(curRotate == 1) {
			int tmp = gear[cur] & 1<<0;
			gear[cur] = gear[cur] >> 1;
			gear[cur] |= 128*tmp;
		}else {
			gear[cur] = gear[cur] << 1;
			int tmp = gear[cur] >>8;
			gear[cur] &= 255;
			gear[cur] |= tmp;
			
		}
	}
}
