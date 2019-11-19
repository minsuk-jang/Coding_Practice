package programmers;
//���� ����
import java.util.*;

public class problem_41 {
	public static void main(String[] args) {
		int n = 1;
		int[] result = solution(n);
		for(int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(int n) {
		int[] result =  new int[(int)(Math.pow(2, n)-1)]; 
		
		Vector<Integer> v = new Vector<>();
		dfs(v, 1, n,0);
		
		for(int i =0 ; i< v.size() ; i++) {
			result[i] = v.get(i);
		}
		
		return result;
	}
	
	public static void dfs(Vector<Integer> v, int idx , int n, int value) {
		if(idx == n ) {
			//���� ���� Ƚ���� ���� ���� ���
			v.add(value);
			return;
		}
		
		dfs(v,idx+1,n,0); //����
		v.add(value); ///���
		dfs(v, idx+1, n, 1); //����
	}
}