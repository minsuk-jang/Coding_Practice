package programmers1;

//���� ū ����
import java.util.*;

public class problem_39 {
	public static void main(String[] args) {
		int result = solution(15);
		System.out.println(result);
	}

	public static int solution(int n) {
		int bitCount = Integer.bitCount(n); //��Ʈ���� 1�� ������ ����
		int tmpCount = 0;
		int answer =0 ;
		while(true) {
			n++;
			tmpCount = Integer.bitCount(n);
			if(bitCount == tmpCount)
			{
				answer = n;
				break;
			}
		}
		
		return answer;
	}
}