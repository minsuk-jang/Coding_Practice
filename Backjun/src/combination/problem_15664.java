package combination;

//N�� M(10)
import java.util.*;
import java.io.*;

public class problem_15664 {
	static Set<String> doubleCheck;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] value = new int[N];
		doubleCheck = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < N;i ++) { 
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(value);
		StringBuilder sb= new StringBuilder();
		int depth =0,next =0 ;
		dfs(depth,next,M,value,sb);
	}
	
	private static void print(String s) {
		System.out.println(s);
	}
	
	private static void dfs(int depth , int next, int M,int[] value , StringBuilder sb) {
		if(depth == M)
		{
			if(!doubleCheck.contains(sb.toString().trim()))
			{
				print(sb.toString().trim());
				doubleCheck.add(sb.toString().trim());
			}
		}
		
		for(int i = next ;i < value.length ; i++) 
		{
			String tmp = Integer.toString(value[i]);
			sb.append(tmp + " ");
			dfs(depth+1,i+1,M,value,sb);
			sb.delete(sb.length()-tmp.length()-1, sb.length());
		}
	}
}
