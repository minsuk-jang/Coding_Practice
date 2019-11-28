package samsung;
//�κ� û�ұ�

import java.util.*;
import java.io.*;

public class problem_14503 {
	static int map[][];
	static int rl[] = { 0, 1, 0, -1 }; // ���� ����
	static int ud[] = { -1, 0, 1, 0 }; // ���� ����
	static boolean visited[][]; // �κ��� û���ߴ°��� �Ǵ��ϴ� ������ �迭
	static int count; // �κ��� û���� ����
	static int tmpX, tmpY;
	static int M, N;

	static boolean disactivate;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine()); // �о����
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N]; // �� ����
			visited = new boolean[M][N];

			st = new StringTokenizer(br.readLine()); // ���� ���� �о�帲
			int robotX = Integer.parseInt(st.nextToken());
			int robotY = Integer.parseInt(st.nextToken());

			//��:0, ��:1, ��:2,��:3
			int direction = Integer.parseInt(st.nextToken()); // ����

			// �� �� �ֱ�
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(robotX, robotY, direction);
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static int dfs(int x, int y, int direction) {
		int initialDirection = direction; // �ʱ� ��ġ
		direction = (direction + 3) % 4;
		while (true) {
			if(disactivate)
				return 0;
			
			if (!visited[x][y]) {
				// ���� ��ǥ�� �湮�� ������ ���
				count++;
				visited[x][y] = true;
			}

			// ���� ��ǥ ����
			int nx = x + ud[direction];
			int ny = y + rl[direction];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N) // ���� ��ǥ���� ������ �Ѿ�� ���
				continue;

			if (!visited[nx][ny] && map[nx][ny] != 1) {
				// ���� ��ǥ���� �湮���� �ʾ��� ���
				initialDirection = dfs(nx, ny, direction);

				// ���� ��ǥ
				x = tmpX;
				y = tmpY;
				direction = (initialDirection + 3) % 4;
			} else if (initialDirection == direction) {
				// �� ������ �� ������ ���
				if (which(x, y, direction)) {
					// �� ������ ��� �湮�߰ų� ���� �����ϰ�, �ڿ� ���� ���� ���
					return direction; // �ش� ���� return
				} else {
					disactivate = true;
				}
			} else
				direction = (direction + 3) % 4;// ���� ��ȯ
		}
	}

	private static boolean which(int x, int y, int direction) {
		switch (direction) {
		case 0: { // ������ ������ ���, ���ʿ� ���� �ִ��� �Ǵ�
			if (map[x + 1][y] == 0) {
				tmpX = x + 1;
				tmpY = y;
				return true;
			}
			break;
		}
		case 1: { // ������ ������ ���, ���ʿ� ���� �ִ��� �Ǵ�
			if (map[x][y -1] == 0) {
				tmpX = x;
				tmpY = y -1;
				return true;
			}
			break;
		}
		case 2: { // ������ ������ ���, ���ʿ� ���� �ִ��� �Ǵ�
			if (map[x - 1][y] == 0) {
				tmpX = x - 1;
				tmpY = y;
				return true;
			}
			break;
		}
		case 3: { // ������ ������ ���, ���ʿ� ���� �ִ��� �Ǵ�
			if (map[x][y + 1] == 0) {
				tmpX = x;
				tmpY = y + 1;
				return true;
			}
			break;
		}
		}

		return false;
	}
}