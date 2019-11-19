package programmers;
// [1��] ������ 4����
//�ڸ��� ó��
import java.util.*;

public class problem_43 {
	public static void main(String[] args) {
		String[] board = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"
				};
		int result = solution(5,6,board);
		System.out.println(result);
	}

	public static int solution(int m, int n, String[] board) {
		Set<String> doubleCheck = new HashSet<>(); // �ߺ��� üũ�ϱ����� ����
		char[][] map = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			String tmp = board[i];
			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j); // ���ڷ� �ٽ� �ֱ�
			}
		}

		int answer = 0;
		while (true) {
			// 2x2�� ã�� ����
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '0' && isBlock(map, i, j)) {
						makeBlock(doubleCheck, i, j); // ���߿� ���� ��ǥ
					}
				}
			}

			if(doubleCheck.size() == 0)
				break; 
			// ã�� �� ���� ����
			answer += doubleCheck.size();
			delete(doubleCheck, map);
			doubleCheck.clear(); // ��ǥ ����

			// ������ ������ ����
			for (int i = map.length-1; i >=0; i--) {
				for (int j = map[i].length-1; j >=0; j--) {
					if (map[i][j] != '0') {
						// �ش� ��ġ�� ��ĭ�� �ƴ� ���
						downBlock(map, i, j);
					}
				}
			}
			
		}
		
		return answer;
	}

	public static void downBlock(char[][] map, int x, int y) {
		int nx = x;
		while (true) {
			nx = nx + 1;
			
			if(nx >= map.length)
				break;
			
			if (map[nx][y] != '0')
				break;
		}
		if((nx-1) != x) {
			map[nx-1][y] = map[x][y]; // ������ ������ ��ġ
			map[x][y] = '0'; // ���� ��ġ�� ������
		}
	}

	public static void delete(Set<String> set, char[][] map) {
		// �־� ���� ��ǥ�� ������� ����
		Iterator it = set.iterator();
		while (it.hasNext()) {
			String[] tmp = ((String)it.next()).split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			
			map[x][y] = '0'; // ��ĭ����
		}

	}

	public static void makeBlock(Set<String> set, int x, int y) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(x + i).append(' ').append(y + j);
				set.add(sb.toString()); // x,y ��ǥ�� ���տ� �ִ´�.
			}
		}
	}

	public static boolean isBlock(char[][] map, int x, int y) {
		char target = map[x][y];
		
		boolean check = false;
		
		if(y + 1 >= map[x].length || x + 1 >= map.length)
			return check;
		
		if (target == map[x + 1][y] && target == map[x][y + 1] && target == map[x + 1][y + 1])
			return !check; // 2x2�� �� ���
		return check;
	}
}