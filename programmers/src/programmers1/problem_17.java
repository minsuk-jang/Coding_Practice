package programmers1;

//��Ʋ ������

import java.util.*;

public class problem_17 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		String[] s = { "B.A","..*","B.*" };
		String result = solution(3, 3, s);
		System.out.println(result);
	}

	public static String solution(int m, int n, String[] board) {
		char[][] map = new char[m][n];
		Queue<Character> queue = null;
		Set<Character> set = new TreeSet<>(); // ���ڸ� ������������ ����
		// map �ʱ�ȭ
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
				if (map[i][j] >= 'A' && map[i][j] <= 'Z')
					set.add(map[i][j]);
			}
		}

		queue = new LinkedList<>(set);
		Queue<Character> queue1= new LinkedList<>(queue);
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		char first = queue.peek();
		int count = 0; //�ߺ� äũ
		while (!queue.isEmpty()) {
			char target = queue.poll();
			first = target;
			outter: for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == target) {
						// �߰����� ��� �̵�
						if(!check(i,j,map)) {
							queue.add(target);
							count++;
						}else {
							queue = sort(queue);
							sb.append(target);
							count = 0;
						}
						break outter;
					}
				}
			}
			
			if(count > queue.size())
				return "IMPOSSIBLE";
		
		}
		return sb.toString();
	}
	

	private static boolean check(int x, int y, char[][] map) {
		int tmpX = x, tmpY = y;

		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = x + ud[i];
				int ny = y + rl[i];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || map[nx][ny] == '*')
					break;

				if (map[nx][ny] == '.') {
					if (move(tmpX, tmpY, nx, ny, i, map))
						return true;
				} else {
					// �� Ȥ�� Ÿ���� �ִ� ���
					if (map[nx][ny] == map[tmpX][tmpY]) { // ������ǥ�� ���� ���
						map[nx][ny] = '.';
						map[tmpX][tmpY] = '.';
						return true;
					}
					else
						break;
				}

				x = nx;
				y = ny;
			}
			x = tmpX;
			y = tmpY;
		}

		return false;
	}

	private static boolean move(int px, int py, int x, int y, int direction, char[][] map) {
		direction = (direction + 1) % 4;
		int tmpX = x, tmpY = y;
		for (int i = 0; i < 2; i++) {
			// ��,�Ʒ� Ȥ�� ����, ���������� ���ϱ� ����
			while (true) {
				int nx = x + ud[direction];
				int ny = y + rl[direction];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || map[nx][ny] == '*')
					break;

				if (map[nx][ny] != '.') {
					x = nx;
					y = ny;
					break;
				}

				x = nx;
				y = ny;
			}

			if (map[x][y] == map[px][py]) {
				map[x][y] = '.';
				map[px][py] = '.';
				return true;
			}
			direction = (direction + 2) % 4;
			x = tmpX;
			y = tmpY;
		}

		return false;
	}

	private static Queue<Character> sort(Queue<Character> queue) {
		TreeSet<Character> set = new TreeSet<>(queue); // ���� ���� ������������ ����
		queue = new LinkedList<>(set); // ���ĵ� ���ڸ� �ٽ� ť�� ����
		return queue;
	}
}