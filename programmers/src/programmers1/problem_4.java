package programmers1;

//입국 심사
import java.util.*;

public class problem_4 {
	public static void main(String[] args) {
		int [] tmp = {7,10};
		long result = solution(6,tmp);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times); //시간을 오름차순으로 정렬
		long low =1 , high= Long.MAX_VALUE;
		long result = high;
		long mid = 0 ; //중간 값
		long count = 0;
		
		if(times.length >= n)
			return times[n-1];
		
		while(low <= high) {
			count =0 ;
			mid = (low + high)/2;
			for(int i =0 ; i< times.length ; i++) {
				count += mid / times[i];	
			}
			
			if(count >= n) {
				high = mid-1; //개수가 클 경우에는 중간값을 최댓값으로 지정
				result = Math.min(result, mid);
			}
			else
				low = mid+1; //개수가 작을 경우에는 중간값을 최소값으로 지정
			
		}
		
		return result;
	}
}
