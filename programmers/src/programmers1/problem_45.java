package programmers1;

//문자열을 정수로 바꾸기
public class problem_45 {
	public int solution(String s) {
		int answer =0 ;
		
		if(s.charAt(0) == '+') {
			answer = Integer.parseInt(s.substring(1,s.length()));
		}else if(s.charAt(0) == '-')
			answer = Integer.parseInt(s.substring(1,s.length())) * -1;
		else
			answer = Integer.parseInt(s);
		
		return answer;
		
	}
}
