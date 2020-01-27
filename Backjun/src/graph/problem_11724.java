package graph;

//���� ��� ����

 import java.util.*;
 import java.io.*;
 
public class problem_11724 {
	static List<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //������ ����
		int M = Integer.parseInt(st.nextToken()); //������ ����
		
		list = new ArrayList[N];
		
		for(int i = 0; i < N ; i++) list[i] =new ArrayList<>();
		
		//���� ����Ʈ
		for(int i =0 ; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken())-1;
			list[k].add(l);
			list[l].add(k);
		}
		
		boolean visited[] = new boolean[N];
		
		int answer =0 ;
		for(int i =0 ; i< N ; i++) {
			if(!visited[i]) {
				answer++;
				dfs(i,visited);
			}
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int idx, boolean[] visited) {
		
		
		visited[idx] = true;
		for(int i =0 ; i< list[idx].size() ; i++) {
			int index = list[idx].get(i);
			if(!visited[index]) {
				//���� �湮�� ���� �ƴ϶��
				dfs(index,visited);
			}
		}
	}
}