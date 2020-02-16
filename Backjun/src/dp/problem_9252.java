package dp;

//LCS 2
import java.io.*;
import java.util.*;

public class problem_9252 {
	static String a, b;
	static StringBuilder sb;
	static int[][] dp;
	static int IMPOSSIBLE = -1000000;
	static String answer= "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = br.readLine();
		b = br.readLine();
		sb = new StringBuilder();

		dp = new int[a.length()][b.length()];

		for (int i[] : dp)
			Arrays.fill(i, IMPOSSIBLE);

		int aPos = 0;
		int bPos = 0;

		int result = dfs(aPos, bPos);
		System.out.println(result);
		
		reconstruction(a.length()-1,b.length()-1);
		
		StringBuilder sb = new StringBuilder(answer);
		sb = sb.reverse();
		answer = sb.toString();
		System.out.println(answer.trim());
	}
	
	private static void reconstruction(int aPos, int bPos) {
		if(aPos < 0 || bPos < 0)
			return;
		
		if(a.charAt(aPos) == b.charAt(bPos)) {
			answer += a.charAt(aPos);
			reconstruction(aPos-1,bPos-1);
		}else if(aPos - 1 >= 0 && bPos-1 >= 0 &&dp[aPos-1][bPos] >= dp[aPos][bPos-1]) {
			reconstruction(aPos-1,bPos);
		}else
			reconstruction(aPos,bPos-1);
		
		return;
	}

	private static int dfs(int aPos, int bPos) {
		if (aPos >= a.length() || bPos >= b.length()) {
			return 0;
		}

		if (dp[aPos][bPos] != IMPOSSIBLE)
			return dp[aPos][bPos];

		if (a.charAt(aPos) == b.charAt(bPos)) {
			dp[aPos][bPos] = 1;
			dp[aPos][bPos] += dfs(aPos + 1, bPos + 1);
		}

		dp[aPos][bPos] = Math.max(dp[aPos][bPos], Math.max(dfs(aPos + 1, bPos), dfs(aPos, bPos + 1)));

		return dp[aPos][bPos];

	}

}
