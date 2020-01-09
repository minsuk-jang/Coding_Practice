package dp;

//����2

import java.io.*;
import java.util.*;

public class problem_10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		long MOD = 1000000000;
		
		long [][] dp = new long [101][9];
		long total = 0;
		
		Arrays.fill(dp[1], 1);

		for(int i =2 ; i<= N ; i++) {
			for(int j = 8 ; j>=0 ; j--) {
				if(j==8) {
					//9�� ��� 
					dp[i][j] = dp[i-1][j-1] % MOD; //���� 1�� ���� �����´�
				}
				if(j >= 1 && j < 8) {
					//2~8
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
				}
				if(j== 0) {
					//1�� ���
					dp[i][j] = dp[i][7] % MOD; //8�� ���� �����´�.
				}
				
			}
		}
		
		for(int i = 0 ; i < 9 ; i++)
			total = (total+dp[N][i])%MOD;
	
		System.out.println(total);
	}
	
}