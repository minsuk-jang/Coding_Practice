package programmers1;

//����� ��
public class problem_47 {
	public static void main(String[] args) {
		int n = 12;
		int result = solution(n);
		System.out.println(result);
	}
	public static int solution(int n) {
		int answer =0 ;
		for(int i = n ; i>= 1; i--) {
			if(n % i == 0)
				answer +=i;
		}
		
		return answer;
	}
}
