package programmers;
//저울 정확성은 다 통과

import java.util.*;

public class problem_48 {
	public static void main(String[] args) {
		int tmp [] = {1,1,2,3,6,7,30};
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[] weight) {
		int answer =0 ;
		int sum = 0;
		Arrays.sort(weight);
		if(weight[0] != 1)
			return 1;
		
		for(int i =0 ; i< weight.length ; i++) {
			if(weight[i] > sum+1)
				return sum+1;
			sum += weight[i];
		}
		
		return sum+1;
	}
}
