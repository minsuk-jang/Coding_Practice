package programmers;

//라면 공장
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
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 공급품의 우선 순위, 내림차순
		boolean visited[] = new boolean[dates.length]; //해당 값은 꺼냈다는것을 표시하기위해
		while (stock < k) {
			for (int i = 0; i < dates.length; i++) {
				if (dates[i] <= stock && !visited[i]) {
					queue.offer(supplies[i]); // 값을 넣는다
					visited[i] = true;
				}
			}

			stock += queue.poll(); // 기간 늘림
			answer++;
		}

		return answer;

	}

}
