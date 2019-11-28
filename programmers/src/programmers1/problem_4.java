package programmers1;

//�Ա� �ɻ�
import java.util.*;

public class problem_4 {
	public static void main(String[] args) {
		int [] tmp = {7,10};
		long result = solution(1,tmp);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times); //�ð��� ������������ ����
		long low =1 , high= 1000000000000000000L;

		long result = high;
		long mid = 0 ; //�߰� ��
		
		while(low <= high) {
			mid = (low + high)/2;
			if(count(mid,times,n)) {
				result = Math.min(result, mid);
				high = mid-1; //������ Ŭ ��쿡�� �߰����� �ִ����� ����
			}
			else
				low = mid+1; //������ ���� ��쿡�� �߰����� �ּҰ����� ����
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