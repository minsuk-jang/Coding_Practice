package search_algorithm;

//�� ������Ʈ
import java.util.*;
import java.io.*;

public class problem_9466 {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());

		for (int i = 0; i < c; i++) {
			int M = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[M];
			boolean[] circle = new boolean[M];
			int[] edge = new int[M];

			st = new StringTokenizer(br.readLine());

			// �� �ʱ�ȭ
			for (int j = 0; j < M; j++) {
				edge[j] = Integer.parseInt(st.nextToken()) - 1;
			}

			for (int j = 0; j < edge.length; j++) {
				if (!visited[j]) {
					dfs(edge, j, visited, circle);
				}
			}
			int answer = circle.length;
			answer -= count;
			System.out.println(answer);
			count = 0;
		}
	}

	private static void dfs(int[] edge, int current, boolean[] visited, boolean[] circle) {

		int next = edge[current];

		visited[current] = true;

		if (!visited[next]) {
			dfs(edge, next, visited, circle);
		} else {
			if (!circle[next]) {
				for (int i = next; current != i; i = edge[i]) {
					count++;
				}
				count++;
			}
		}

		circle[current] = true;
	}
}