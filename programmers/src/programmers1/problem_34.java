package programmers1;

//���ϸ�

import java.util.*;
public class problem_34 {
	public static void main(String[] args) {
		int nums[] = {3,1,2,3};
		int result = solution(nums);
		System.out.println(result);
	}
	public static int solution(int[] nums) {
		Set<Integer> set = new TreeSet<>();
		for(int i = 0 ; i< nums.length ; i++) {
			set.add(nums[i]);
		}
		
		int N = nums.length /2;
		
		if(set.size() > N)
			return N;
		else
			return set.size();
		
	}
}
