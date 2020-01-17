package dp;

//����� �賶
import java.util.*;
import java.io.*;

public class problem_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new TreeSet<>(); // �ߺ� ����
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int K = Integer.parseInt(st.nextToken()); // ��ƿ�� �ִ� ����

		List<Node> list[] = new ArrayList[100001];
		for (int i = 1; i < list.length; i++)
			list[i] = new ArrayList<>();

		// �� �Ҵ�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			List<Integer> tmp = null;

			if (!map.containsKey(w)) {
				tmp = new ArrayList<>();
				tmp.add(v);
				map.put(w, tmp);
			} else {
				tmp = map.get(w);
				tmp.add(v);
				tmp.sort(Collections.reverseOrder()); // ������������ ����
				map.put(w, tmp);
			}
			set.add(w);
		}

		Iterator<Integer> it = map.keySet().iterator();

		while (it.hasNext()) {
			int w = it.next();
			int sum = 0;
			int step = 1;
			List<Integer> tmp = map.get(w);
			for (int i = 0; i < tmp.size(); i++) {
				sum += tmp.get(i);
				if (w * step <= K)
					list[w].add(new Node(sum, w * step));
				step++;
			}

		}

		List<Integer> value = new ArrayList<>(set);
		int IMPOSSIBLE = -10000000;
		int[][] dp = new int[value.size()][K + 1];
		for (int[] tmp : dp) {
			Arrays.fill(tmp, IMPOSSIBLE);
		}

		// ù���� �� �߰�
		for (int i = 0; i < list[value.get(0)].size(); i++) {
			int idx = list[value.get(0)].get(i).idx;
			int v = list[value.get(0)].get(i).value;
			dp[0][idx] = v;
		}

		// ������ ��
		for (int i = 1; i < dp.length; i++) {
			System.arraycopy(dp[i - 1], 0, dp[i], 0, value.get(i)); // ���� ��ġ �������� �� ����
			int listIdx = value.get(i);
			for (int j = 0; j < list[listIdx].size(); j++) {
				int currentIdx = list[listIdx].get(j).idx;
				int currentValue = list[listIdx].get(j).value;
				dp[i][currentIdx] = Math.max(dp[i - 1][currentIdx], currentValue);
				for (int k = currentIdx + 1; k <= K; k++) {
					dp[i][k] = Math.max(dp[i][k], Math.max(dp[i - 1][k], currentValue + dp[i - 1][k - currentIdx]));
				}
			}
		}
		int big = 0;
		for (int i = 0; i < dp[value.size() - 1].length; i++) {
			big = Math.max(big, dp[value.size() - 1][i]);
		}
		System.out.println(big);

	}

	private static class Node {
		int value, idx;

		public Node(int v, int i) {
			this.value = v;
			this.idx = i;
		}
	}
}