package programmers1;

//�ùٸ� ��ȣ
public class problem_18 {
	public static void main(String[] args) {
		boolean result = solution("()))((");
		System.out.println(result);
	}
	
	private static boolean solution(String s) {
		boolean answer = false;
		int count = 0;
		
		for(int i =0 ; i< s.length() ; i++) {
			if(count < 0)
				return false;
			if(s.charAt(i) == '(')
				count++;
			else
				count--;
		}
		
		
		if(count == 0)
			return !answer;
		return answer;
	}
}