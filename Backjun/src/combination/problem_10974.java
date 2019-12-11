package combination;

//모든 순열
import java.io.*;
import java.util.*;

public class problem_10974 {
	static boolean visited[];
	static int N;
	static Deque<Integer> queue;
	public static void main(String[] args) {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		try {
		N = Integer.parseInt(br.readLine());
		queue =new LinkedList<>();
		visited= new boolean[N];
		
		for(int i= 0 ; i< visited.length; i++) {
			if(!visited[i])
			{
				visited[i] = true;
				queue.add(i+1); //값 삽입
				dfs(1);
				visited[i] = false;
				queue.pollLast();
			}
		}
		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void dfs(int depth) {
		if(depth == N) {
			show();
			return;
		}
		
		for(int i =0 ; i< N ; i++) {
			if(!visited[i])
			{
				visited[i]=  true;
				queue.add(i+1);
				dfs(depth+1);
				visited[i] = false;
				queue.pollLast();
			}
		}
	}
	private static void show() {
		List<Integer> list = new ArrayList<>(queue);
		for(int i =0 ; i<list.size() ; i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}
}
