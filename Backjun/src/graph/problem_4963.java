package graph;

//���� ����
import java.util.*;
import java.io.*;

public class problem_4963 {
	static int ud[] = { -1, -1, -1, 0, 1, 1,  1,  0 };
	static int rl[] = { -1,  0,  1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				break;
			
			int[][] map = new int[M][N];
			boolean[][] visited = new boolean[M][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						count++;
						countIsland(i, j, map, visited);
					}
				}
			}

			System.out.println(count);
		}
	}

	private static void countIsland(int x, int y, int[][] map, boolean[][] visited) {

		visited[x][y] = true;

		for (int i = 0; i < ud.length; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			// �ѹ� �湮�� ���� �ְų� �迭 ���� ���� ���
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || visited[nx][ny])
				continue;

			// ���� ��ġ�� 0�� ���
			if (map[nx][ny] == 0)
				continue;

			countIsland(nx, ny, map, visited);
		}
	}
}