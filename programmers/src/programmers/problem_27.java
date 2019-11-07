package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//H-index
public class problem_27 {
	public static void main(String[] args) {
		int tmp[] = {0,1,1,1,1};
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[] citations) {
		ArrayList<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < citations.length; i++) {
			tmp.add(citations[i]);
		}
		Collections.sort(tmp);
		int answer = 1;
		for(int i = 0 ; i < tmp.size() ; i++) {
			int high = tmp.size() - i;
			int cite = tmp.get(i);
			if(high <= cite) {
				answer = Math.max(answer, high); 
			}
		}
		
		return answer;
	}
}
