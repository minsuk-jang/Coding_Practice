package programmers1;

//��ü ���� ���

public class problem_14 {
	static int count = 0;

	public static void main(String[] args) {
		String[] data = { "M~C<2", "C~M>1" };
		int result = solution(2, data);
		System.out.println(result);

	}

	public static int solution(int n, String[] data) {
		char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'  };
		dfs(friends, 0, n, data);
		return count;
	}

	private static void checkCondition(char[] friends, int n, String[] data) {
		String friend = new String(friends);
		for (int i = 0; i < n; i++) {
			char first = data[i].charAt(0);
			char second = data[i].charAt(2);
			char condition = data[i].charAt(3);
			int count = data[i].charAt(4) - '0';

			int firstIndex = friend.indexOf(first); // ù��° ģ���� ���� ��ġ
			int secondIndex = friend.indexOf(second); // �ι�° ģ���� ���� ��ġ
			int diff = 0;
			if (condition == '=' && Math.abs(secondIndex - firstIndex) - 1 == count) {
				continue;
			} else if (condition == '>' && Math.abs(secondIndex - firstIndex) - 1 > count) {
				continue;
			} else if (condition == '<' && Math.abs(secondIndex - firstIndex) - 1 < count) {
				continue;
			}else
				return;
		}
		count++;// ������ �� ���� ���
		return;
	}

	private static void dfs(char[] friends, int depth, int n, String[] data) {
		if (depth == friends.length) {
			checkCondition(friends, n, data);
			return;
		}

		for (int i = depth; i < friends.length; i++) {
			swap(i, depth, friends);
			dfs(friends, depth + 1, n, data);
			swap(i, depth, friends);
		}
	}

	private static void swap(int i, int depth, char[] friends) {
		char tmp = friends[depth];
		friends[depth] = friends[i];
		friends[i] = tmp;
	}
}