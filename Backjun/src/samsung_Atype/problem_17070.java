package samsung_Atype;

//������ �ű�� 1
import java.util.*;
import java.io.*;

public class problem_17070 {
	static int count = 0;
	public static void main(String[] args0) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		StringTokenizer st = null;

		// �ʱ�ȭ ����
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0, 1, map, 'U');
		System.out.println(count);
	}

	private static void dfs(int lx, int ly, int rx, int ry, int[][] map, char direction) {
		if (isReach(lx, ly, rx, ry, map.length - 1)) {
			count++;
			return;
		}
		// ���� ������ ���� ������ �����ϰ� �ȴ�.
		int nlx = 0, nly = 0, nrx = 0, nry = 0;
		switch (direction) {
		case 'U': {
			// ����
			int ud[] = { 0, 1 };
			int rl[] = { 1, 1 };
			char[] d = {'U','R'};
			for (int i = 0; i < 2; i++) {
				// ���� ��ǥ
				nlx = rx;
				nly = ry;
				nrx = rx + ud[i];
				nry = ry + rl[i];

				// �迭�� ������ ����� ���
				if (nrx < 0 || nrx >= map.length || nry < 0 || nry >= map.length)
					continue;

				// �ش� ��ġ�� ���� ������ ���
				if (map[nrx][nry] == 1)
					continue;
				
				if (d[i] == 'R') {
					// �밢���� ���, ���� ���ʿ� ���� �����ϴ� �� �Ǵ�
					if (map[nrx][nry - 1] == 1 || map[nrx - 1][nry] == 1)
						continue;
				}
				dfs(nlx, nly, nrx, nry, map, d[i]);
			}
			break;
		}
		case 'D': {
			// ����
			int ud[] = { 1, 1 };
			int rl[] = { 0, 1 };
			char[] d = {'D','R'};
			for (int i = 0; i < 2; i++) {
				// ���� ��ǥ
				nlx = rx;
				nly = ry;
				nrx = rx + ud[i];
				nry = ry + rl[i];

				// �迭�� ������ ����� ���
				if (nrx < 0 || nrx >= map.length || nry < 0 || nry >= map.length)
					continue;
				// �ش� ��ġ�� ���� ������ ���
				if (map[nrx][nry] == 1)
					continue;
				
				if (d[i] == 'R') {
					// �밢���� ���, ���� ���ʿ� ���� �����ϴ� �� �Ǵ�
					if (map[nrx][nry - 1] == 1 || map[nrx - 1][nry] == 1)
						continue;
				}
				
				
				dfs(nlx, nly, nrx, nry, map,d[i]);
			}
			break;
		}
		case 'R': {
			// �밢��
			int ud[] = { 0, 1, 1 };
			int rl[] = { 1, 0, 1 };
			char[] d = {'U','D','R'};
			for (int i = 0; i < 3; i++) {
				// ���� ��ǥ
				nlx = rx;
				nly = ry;
				nrx = rx + ud[i];
				nry = ry + rl[i];

				// �迭�� ������ ����� ���
				if (nrx < 0 || nrx >= map.length || nry < 0 || nry >= map.length)
					continue;
				// �ش� ��ġ�� ���� ������ ���
				if (map[nrx][nry] == 1)
					continue;
				
				if (d[i] == 'R') {
					// �밢���� ���, ���� ���ʿ� ���� �����ϴ� �� �Ǵ�
					if (map[nrx][nry - 1] == 1 || map[nrx - 1][nry] == 1)
						continue;
				}
				dfs(nlx, nly, nrx, nry, map, d[i]);
			}
			break;
		}
		}
	}

	private static boolean isReach(int lx, int ly, int rx, int ry, int N) {
		if ((lx == N && ly == N) || (rx == N && ry == N))
			return true;
		return false;
	}
}