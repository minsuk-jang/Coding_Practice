package programmers1;
//���� �� �Ӹ���� 
//manacher �˰�����
import java.util.*;

public class problem_12 {
	public static void main(String[] args) {
		int result = solution("abcdcba");
		System.out.println(result);
	}

	public static int solution(String s) {
		String updateString = getUpdateString(s);
		int answer =0 ;
		int p[] = new int[updateString.length()];
		int c=0,r=0; //center, rightBounday
		
		for(int i = 1; i< updateString.length() ; i++) {
			//String ��ȸ
			int mirror = 2*c - i;
			
			if(i < r)
				p[i] = Math.min(r-i, p[mirror]);
			
			
			int left = i-(1+p[i]);
			int right = i+(1+p[i]);
			while(right < updateString.length() && left >= 0 && updateString.charAt(left) == updateString.charAt(right) ) {
				//Ȯ��
				left--;
				right++;
				p[i]++; 
			}
			
			if(i+ p[i] > r) {
				//rightBoundary�� �Ѿ��� ���
				c = i; //center ����
				r = i + p[i]; //right boundary ����
				
				answer = Math.max(p[i],answer); //���� ū ���� ���ϱ� ���� 
			}
		}
		
		
		return answer;
		
	}
	private static String getUpdateString(String s) {
		//#�� ���� String�� ��� ���� �޼ҵ�
		StringBuilder sb  =new StringBuilder(s);
		for(int i =0 ; i< s.length() ; i++) {
			sb.insert(i+(i+1), '#');
		}
		sb.insert(0, '#');
		
		return sb.toString();
	}
}