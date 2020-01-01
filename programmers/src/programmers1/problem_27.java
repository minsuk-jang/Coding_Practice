package programmers1;

//점프와 순간 이동
import java.util.*;

public class problem_27 {
	public static void main(String[] args) {
		int result = solution(5);
		System.out.println(result);
	}
	
	public static int solution(int n) {
		int answer =0 ;
		int jump = 1;
		
		while(n != 1) {
			if(n % 2 == 0)
				n /=2;
			else {
				n -= 1;
				jump++;
			}
		}
		
		return jump;
	}
}
