package network_flow;

import java.util.*;

//이분 매칭 테스트
public class test {
	static List<Integer> list [];
	static boolean check[];
	static int target[];
	
	public static void main(String[] args) {
		list =new ArrayList[3];
		check = new boolean[3];
		target = new int[3];
		Arrays.fill(target, -1);
		
		for(int i =0 ; i< list.length ; i++) list[i] = new ArrayList<>();
		
		list[0].add(0);
		list[0].add(1);
		list[0].add(2);
		
		list[1].add(0);
		list[2].add(1);
		
		int count = 0;
		
		for(int i = 0 ; i < list.length ; i++) {
			if(dfs(i))
				count++;
			Arrays.fill(check, false);
		}
		
		for(int i = 0 ; i < target.length ; i++) {
			System.out.println(target[i]+1 + " -> " + (i+1));
		}
		
		System.out.println(count);
	}
	
	//매칭이 되면 true, 아니면 false를 반환한다.
	private static boolean dfs(int cur) {
		
		
		for(int next : list[cur]) {
			//이미 점유한 것이라면
			if(check[next])
				continue;
			
			check[next] = true;
			
			//아직 점유하지 않았거나 더 들어갈 공간이 있는 경우
			if(target[next] == -1|| dfs(next)) {
				target[next] = cur;
				return true;
			}
		}
		
		return false;
	}
	
}

