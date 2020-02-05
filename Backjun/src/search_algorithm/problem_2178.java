package search_algorithm;

//�̷� Ž��
import java.util.*;
import java.io.*;

public class problem_2178 {
	static int[][] map;
	static boolean[][] visited;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		dfs(0, 0,N,M);
	}

	private static void dfs(int x, int y, int N, int M) {
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };
		Queue<List<Integer>> queue = new LinkedList<>();

		visited[x][y] = true; // ���� ��ǥ �湮 �Ϸ�
		board[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)
				continue;

			// ���� ��ǥ
			List<Integer> tmp = new ArrayList<>();
			tmp.add(nx);
			tmp.add(ny);
			queue.add(tmp);
			board[nx][ny] = board[x][y] + 1;
		}

		while (!queue.isEmpty()) {
			List<Integer> current = queue.poll();
			int cx = current.get(0);
			int cy = current.get(1);

			if (!visited[cx][cy]) {
				// ���� �湮�� ���� �ƴ϶��
				visited[cx][cy] = true;
				for (int i = 0; i < 4; i++) {
					int nx = cx + ud[i];
					int ny = cy + rl[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0)
						continue;

					//���� ��ǥ�� ���� �湮���� ���� ���̶��
					if (!visited[nx][ny]) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(nx);
						tmp.add(ny);
						board[nx][ny] = board[cx][cy] + 1;
						queue.add(tmp);
					}
				}
			}
		}
		
		System.out.println(board[N-1][M-1]);
	}
}