package programmers1;

//���� �̵��ϱ�
import java.util.*;

public class problem_32 {
	static boolean[][][][] visited = new boolean[101][101][101][101]; // �ߺ� �湮�� ����
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		int result = solution(board);
		System.out.println(result);
	}

	public static int solution(int[][] board) {
		int[][] map = new int[board.length][board[0].length];
		// �迭 �� ����
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(board[i], 0, map[i], 0, board.length);
		}

		Queue<Node> queue = new LinkedList<>(); // BFS�� �����ϱ� ���� ť
		queue.add(new Node(0, 0, 0, 1, 0)); // �ʱ� ��ǥ
		visited[0][0][0][1] = true; // ���� ��ġ �湮
		int answer = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int leftX = cur.leftX, leftY = cur.leftY;
			int rightX = cur.rightX, rightY = cur.rightY;
			int cc = cur.count;

			if (isReach(leftX, leftY, rightX, rightY, map.length-1)) {
				answer = cc;
				break;
			}
			direction(leftX, leftY, rightX, rightY, cc, map, queue); // 4���� ������ �湮
			rotation(leftX, leftY, rightX, rightY, cc, map, queue); // ȸ��
		}

		return answer;
	}

	private static void rotation(int lx, int ly, int rx, int ry, int cc, int[][] map, Queue<Node> queue) {
		// ������ �ΰ��� ��ƾ� ��
		// ������ ������ �� ���
		int d = whichDirection(lx, ly, rx, ry);
		rotation(d, lx, ly, rx, ry, cc, map, queue);

		// �������� ������ �� ���
		d = whichDirection(rx, ry, lx, ly);
		rotation(d, rx, ry, lx, ly, cc, map, queue);

	}

	private static void rotation(int d, int baseX, int baseY, int targetX, int targetY, int cc, int[][] map,
			Queue<Node> queue) {
		int count = cc;
		if (d == 0 || d == 2) {
			// Ÿ���� ��ġ�� �� Ȥ�� ���� ���
			int ud[] = new int[2];

			if (d == 0) {
				ud[0] = 1;
				ud[1] = 1;
			} else {
				ud[0] = -1;
				ud[1] = -1;
			}
			int rl[] = { -1, 1 };
			for (int i = 0; i < 2; i++) {
				int nx = targetX + ud[i];
				int ny = targetY + rl[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) // ���� ���� ���
					continue;

				if (map[targetX][targetY + rl[i]] == 1 || map[nx][ny] == 1) // ȸ���ߴµ� ���� ���� ���
					continue;

				if (ny < baseY) {
					if (!visited[nx][ny][baseX][baseY]) {
						visited[nx][ny][baseX][baseY] = true;
						queue.add(new Node(nx, ny, baseX, baseY, count + 1));
					}
				} else {
					if (!visited[baseX][baseY][nx][ny]) {
						visited[baseX][baseY][nx][ny] = true;
						queue.add(new Node(baseX, baseY, nx, ny, count + 1));
					}
				}
			}
		} else {
			// Ÿ���� ��ġ�� �� Ȥ�� ���� ���
			int ud[] = { -1, 1 };
			int rl[] = new int[2];

			if (d == 1) {
				// Ÿ���� ������ ���
				rl[0] = -1;
				rl[1] = -1;
			} else {
				rl[0] = 1;
				rl[1] = 1;
			}

			for (int i = 0; i < 2; i++) {
				int nx = targetX + ud[i];
				int ny = targetY + rl[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) // ���� ���� ���
					continue;

				if (map[targetX + ud[i]][targetY] == 1 || map[nx][ny] == 1) // ȸ���ߴµ� ���� ���� ���
					continue;

				if (nx < baseX) {
					if (!visited[nx][ny][baseX][baseY]) {
						visited[nx][ny][baseX][baseY] = true;
						queue.add(new Node(nx, ny, baseX, baseY, count + 1));
					}
				} else {
					if (!visited[baseX][baseY][nx][ny]) {
						visited[baseX][baseY][nx][ny] = true;
						queue.add(new Node(baseX, baseY, nx, ny, count + 1));
					}
				}
			}
		}
	}

	private static int whichDirection(int baseX, int baseY, int targetX, int targetY) {
		int x = baseX - targetX;
		int y = baseY - targetY;
		int direction = 0;
		if (x == 0) {
			if (y < 0)
				direction = 1;
			else
				direction = 3;
		} else {
			if (x < 0)
				direction = 2;
			else
				direction = 0;
		}

		return direction;
	}

	private static boolean isReach(int lx, int ly, int rx, int ry, int N) {
		if ((lx == N && ly == N) || (rx == N && ry == N)) // �� �� ��, �Ѱ��� (N,N)�� �������� ���
			return true;

		return false;

	}

	private static void direction(int lx, int ly, int rx, int ry, int cc, int[][] map, Queue<Node> queue) {
		int baseX = Math.min(lx, rx); // ����
		int baseY = Math.min(ly, ry); // ����
		int baseXX = Math.max(lx, rx); // ����
		int baseYY = Math.max(ly, ry); // ����
		int count = cc;
		// ����
		int nx = baseX + ud[0];
		if (nx >= 0) // ���� ���� ������ ���
		{
			if (map[lx - 1][ly] == 0 && map[rx - 1][ry] == 0) { // �Ѵ� ���� ���� ���
				if (!visited[lx - 1][ly][rx - 1][ry]) {
					visited[lx - 1][ly][rx - 1][ry] = true;
					queue.add(new Node(lx - 1, ly, rx - 1, ry, count + 1));
				}
			}
		}

		// ����
		int ny = baseYY + rl[1];
		if (ny < map[lx].length) {
			if (map[lx][ly + 1] == 0 && map[rx][ry + 1] == 0) {
				if (!visited[lx][ly + 1][rx][ry + 1]) {
					visited[lx][ly + 1][rx][ry + 1] = true;
					queue.add(new Node(lx, ly + 1, rx, ry + 1, count + 1));
				}
			}
		}

		// ����
		nx = baseXX + ud[2];
		if (nx < map.length) {
			if (map[lx + 1][ly] == 0 && map[rx + 1][ry] == 0) {
				if (!visited[lx + 1][ly][rx + 1][ry]) {
					visited[lx + 1][ly][rx + 1][ry] = true;
					queue.add(new Node(lx + 1, ly, rx + 1, ry, count + 1));
				}
			}
		}

		// ����
		ny = baseY + rl[3];
		if (ny >= 0) {
			if (map[lx][ly - 1] == 0 && map[rx][ry - 1] == 0) {
				if (!visited[lx][ly - 1][rx][ry - 1]) {
					visited[lx][ly - 1][rx][ry - 1] = true;
					queue.add(new Node(lx, ly - 1, rx, ry - 1, count + 1));
				}
			}
		}

	}

	private static class Node {
		int leftX, leftY;
		int rightX, rightY;
		int count;

		public Node(int lx, int ly, int rx, int ry, int c) {
			this.leftX = lx;
			this.leftY = ly;
			this.rightX = rx;
			this.rightY = ry;
			this.count = c;
		}
	}
}