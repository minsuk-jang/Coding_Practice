package programmers1;

//입국 심사
import java.util.*;

public class problem_4 {
	public static void main(String[] args) {
		int [] tmp = {7,10};
		long result = solution(1,tmp);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times); //시간을 오름차순으로 정렬
		long low =1 , high= 1000000000000000000L;

		long result = high;
		long mid = 0 ; //중간 값
		
		while(low <= high) {
			mid = (low + high)/2;
			if(count(mid,times,n)) {
				result = Math.min(result, mid);
				high = mid-1; //개수가 클 경우에는 중간값을 최댓값으로 지정
			}
			else
				low = mid+1; //개수가 작을 경우에는 중간값을 최소값으로 지정
		}
		
		return result;
	}
	private static boolean count(long time, int [] times, int n) {
		long count =0 ;
		for(int i =0 ; i< times.length  ;i++) {
			count += time / times[i];
		}
		
		return count >= n;
	}
}
