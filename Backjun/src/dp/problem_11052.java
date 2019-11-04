package dp;
import java.util.*;

public class problem_11052 {
	static int [] array;
	static int [][] dp;
	static int impossible = -10000;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N =scanner.nextInt();
		array = new int[N+1];
		dp = new int[N+1][N+1];
		for(int [] tmp  : dp)
			Arrays.fill(tmp, -1);
		for(int i =1 ; i <= N ; i++) {
			int tmp = scanner.nextInt();
			array[i] = tmp;
		}
		int result = f(1,N);

		System.out.println(result);
	}
	static int f(int idx , int k) {
		if(idx > k)
			return k == 0 ? 0 : impossible;
		if(dp[idx][k] != -1)
			return dp[idx][k];
		int result = f(idx+1,k);
		result= Math.max(result, (f(idx,k-idx) + array[idx]) );
		dp[idx][k] = result;
	
		return result;	
	}
}
