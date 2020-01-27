package samsung_Atype;

//�Ը� �Ǵ���
import java.util.*;
import java.io.*;

public class problem_17471 {
	static int value[]; // ��
	static List<Integer>[] list; // ����� ���
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		value = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N];

		// ����� ��� �ֱ�
		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int l = 0; l < m; l++) {
				list[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		dfs(0, 0, visited);
		System.out.println(answer);
	}

	private static boolean isConnected(boolean part, boolean[] visited, int n,List<Integer> llist) {
		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < llist.size(); i++) {
			int idx = llist.get(i);
			for (int j = 0; j < list[idx].size(); j++) {
				if (!set.contains(list[idx].get(j)) && part == visited[list[idx].get(j)])
					set.add(list[idx].get(j));
			}
		}

		// ũ�Ⱑ �´ٸ�
		if (set.size() == n)
			return true;
		return false;
	}

	private static int calculate(boolean[] visited) {
		int A = 0, B = 0;
		for (int i = 0; i < visited.length; i++)
			if (visited[i])
				A += value[i];
			else
				B += value[i];

		int result = Math.abs(A - B);
		return result;
	}

	private static void dfs(int depth, int next, boolean[] visited) {
		if (depth == visited.length) {
			// ���� ������ ����� ���
			List<Integer> A = new LinkedList<>();
			List<Integer> B = new LinkedList<>();

			// ���� �� ������
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					A.add(i);
				} else
					B.add(i);
			}

			if (!A.isEmpty() && !B.isEmpty()) {
				if (isConnected(true, visited, A.size(),A) && isConnected(false, visited, B.size(),B)) {
					// ����� ���� Ȯ�� �ߴٸ�
					if (answer == -1)
						answer = calculate(visited);
					else
						answer = Math.min(answer, calculate(visited));
				}
			}

			return;
		}

		for (int i = next; i < visited.length; i++) {
			visited[i] = true;
			dfs(depth + 1, i + 1, visited);
			visited[i] = false;
			dfs(depth + 1, i + 1, visited);
		}
	}
}