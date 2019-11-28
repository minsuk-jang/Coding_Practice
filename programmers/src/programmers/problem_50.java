package programmers;

//��� ����
import java.util.*;;

public class problem_50 {
	public static void main(String[] args) {
		int[] tmp = { 4, 10, 15 };
		int[] supp = { 20, 5, 10 };

		int result = solution(4, tmp, supp, 30);
		System.out.println(result);
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // ����ǰ�� �켱 ����, ��������
		boolean visited[] = new boolean[dates.length]; //�ش� ���� ���´ٴ°��� ǥ���ϱ�����
		while (stock < k) {
			for (int i = 0; i < dates.length; i++) {
				if (dates[i] <= stock && !visited[i]) {
					queue.offer(supplies[i]); // ���� �ִ´�
					visited[i] = true;
				}
			}

			stock += queue.poll(); // �Ⱓ �ø�
			answer++;
		}

		return answer;

	}

}