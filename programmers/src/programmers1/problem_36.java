package programmers1;
//������ ǥ��

public class problem_36 {
	public static void main(String[] args) {
		int result = solution(15);
		System.out.println(result);
	}

	public static int solution(int n) {
		int answer = 0;
		int idx = 1;
		while (idx <= n) {
			int sum = 0;
			int index = idx;
			while(true) {
				sum += index;
				if(sum == n) { //������ �ڿ������ n�� ǥ���� ������ ���
					answer++;
					break;
				}
				if(sum > n) //������ �ڿ������ n�� �ʰ��ϴ� ���
					break;
				index++;
			}
			idx++;
		}

		return answer;
	}
}