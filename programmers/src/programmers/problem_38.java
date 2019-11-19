package programmers;
//�ĺ�Ű

import java.util.*;

public class problem_38 {
	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		int result = solution(relation);
		System.out.println(result);
	}

	public static int solution(String[][] relation) {
		int row = relation.length; // �����̼�
		int col = relation[0].length; // �÷�
		int result = 0;
		List<Integer> list = new ArrayList<>(); // ���ϼ��� ��� ����Ʈ
		for (int i = 1; i < (1 << col); i++) {
			// �÷��� ���� ����
			int bitmask = i;
			
			if(minmum(bitmask,list))
				continue;

			if (Unique(bitmask, relation)) // ���ϼ��� ���� �� ���
				list.add(bitmask);
			
			
		}
		return list.size();
	}

	public static boolean Unique(int bitmask, String[][] relation) {
		int row = relation.length;
		int col = relation[0].length;

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < row; i++) {
			// �÷����� �ݺ��� ����
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < col; j++) {
				if ((bitmask & (1<<j)) == (1<<j)) {
					// �ش� ��Ʈ ����ũ�� ������ ũ��
					String tmp = relation[i][j];
					sb.append(tmp);
				}
			}
			String tmp = sb.toString();
			if (set.contains(tmp))
				return false; // ���� �̹� ������ ��� ���ϼ��� ����
			set.add(tmp);
		}

		return true;
	}
	public static boolean minmum(int bitmask, List<Integer> list) {
		for(int tmp : list) {
			if((bitmask & tmp) == tmp)
				return true;		
		}
		
		return false;
	}
}