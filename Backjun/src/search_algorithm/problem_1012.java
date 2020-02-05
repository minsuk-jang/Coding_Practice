package search_algorithm;

//����� ����
import java.util.*;
import java.io.*;

public class problem_1012 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = Integer.parseInt(st.nextToken());
		int [] answerArray = new int[count];
		int current =0 ;
		for(int l =0 ; l < count ; l++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				map[r][c] = 1;

			}

			boolean[][] visited = new boolean[N][M];
			int answer = 0;

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						visited[i][j] = true;
						answer++;
						dfs(i, j, map, visited);
					}
				}
			}
			
			answerArray[current++] = answer;
		}
		for(int i =0 ; i < answerArray.length ; i++)
			System.out.println(answerArray[i]);
	}

	private static void dfs(int x, int y, int[][] map, boolean[][] visited) {
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length)
				continue;

			if (!visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny, map, visited);
			}
		}
	}
}