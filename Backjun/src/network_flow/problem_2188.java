package network_flow;

import java.util.*;
import java.io.*;

//��� ����
public class problem_2188 {
	static List<Integer> link[];
	static int target[];
	static boolean check[];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		link = new ArrayList[N+1];
		target = new int[M+1];
		check = new boolean[M+1];
		
		for(int i =1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			link[i] = new ArrayList<>();
			
			int k = Integer.parseInt(st.nextToken());
			for(int j = 0; j  < k ; j++) {
				link[i].add(Integer.parseInt(st.nextToken()));
			}
			
		}
		Arrays.fill(target, -1);
		
		int count = 0;
		for(int i =1 ; i <= N ; i++) {
			if(dfs(i))
				count++;
			
			Arrays.fill(check, false);
		}
		
		System.out.println(count);
	}
	
	private static boolean dfs(int cur) {
		
		for(int house : link[cur]) {
			//�ش� ���� �̹� �Ұ� ���� ���
			if(check[house])
				continue;
			
			check[house] = true;
			
			//�ش� ���� �Ұ� ���ų� �ٸ� ���� ���ϴ� ���� ���� ���
			if(target[house] == -1 || dfs(target[house])) {
				target[house] = cur;
				return true;
			}
		}
		
		return false;
	}
}