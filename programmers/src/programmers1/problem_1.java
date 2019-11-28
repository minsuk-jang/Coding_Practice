package programmers1;

//��ũ ��Ʈ��, 30�� -> 45�� 
import java.util.*;

public class problem_1 {
	public static void main(String[] args) {
		int[][] tmp = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, 
				{47, 22}, {20, 47}, {15, 34}, {15, 2}, 
				{35, 43}, {26, 1}};
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[][] jobs) {
		boolean[] visited = new boolean[jobs.length];
		PriorityQueue<Node> queue = new PriorityQueue<>(); // �۾� �ð��� �ֱ����� �켱���� ť
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] < arg1[0]) // ������ �ð��� ������� ���� ���� ����
					return -1;
				else if (arg0[0] == arg1[0]) {
					if (arg0[0] < arg1[1])
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});

		int total = 0; // �� �ð�
		int average = 0; // ��û���� �������
		for (int i = 0; i < jobs.length; i++) {
			for (int j = 0; j < jobs.length; j++) {
				if (total >= jobs[j][0] && !visited[j]) { // �ѹ��� ���� �ʾ����� ���� �ð����� �ִ� ���
					queue.add(new Node(jobs[j][0], jobs[j][1])); // �۾� �ð��� �ִ´�.
					visited[j] = true;
				}
			}

			if (!queue.isEmpty()) {
				// ť�� ���� �ִ� ���
				Node tmp = queue.poll();
				total += tmp.duration;
				average += total - tmp.start;
			} else {
				// ť�� ���� ���� ���, �� �ð� ���� ���� �ʰ� �ָ� ������ �ִ� ���
				// �۾��� �����ϰ� ���� ���� ������ ���� ��û�� ���� �۾����� ó���Ѵ�.
				total = jobs[i][0] + jobs[i][1]; //���۽ð����� �۱� ������
				average += jobs[i][1];
				visited[i] = true;
			}
		}

		return average / jobs.length;
	}

	public static class Node implements Comparable<Node> {
		int start, duration;

		public Node(int s, int d) {
			this.start = s;
			this.duration = d;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.duration < o.duration) // �۾� ���� ������ �������� ����
				return -1;
			else
				return 1;
		}

	}
}