package greedy;

//���� �� �����ϴ� �κм���
import java.util.*;
import java.io.*;

public class problem_12015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];

		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		list.add(input[0]);
		int answer = 1;

		for (int i = 1; i < N; i++) {
			int last = list.get(list.size() - 1);
			int cur = input[i];

			// ���κ��� ���� ������ Ŭ ���
			if (last >= cur) {
				lowerBound(list, cur);
			} else {
				list.add(cur);
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static void lowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();
		int mid = 0;

		while (left < right) {
			mid = (left + right) / 2;
			if (list.get(mid) < target)
				left = mid + 1;
			else
				right = mid;
		}

		list.remove(left);
		list.add(left, target);
	}
}