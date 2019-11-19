package programmers;
//�ܾ� ��ȯ

import java.util.*;

public class problem_45 {
	public static void main(String[] args) {
		String [] tmp = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result = solution("hit","cog",tmp);
		System.out.println(result);
	}

	public static int solution(String begin, String target, String[] words) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]); // ���տ� �� ����
		}

		if(!set.contains(target)) //�ش� ���� ���� ���
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		boolean check = false; // ���ڰ� �Ѱ��� �ٸ��� �Ǵ�
		int count = 0;

		Iterator it = set.iterator();

		//ù �κ�
		while (it.hasNext()) {
			String value = (String) it.next();
			for (int i = 0; i < begin.length(); i++) {
				if (value.charAt(i) != begin.charAt(i))
					count++; // �ٸ� ���� ���� �Ǵ�.
			}
			if (count == 1) {
				// �Ѱ��� �ٸ� ���
				Set<String> tmpOriginal = new HashSet<>(set);
				Set<String> tmpSet = new HashSet<>();
				tmpSet.add(value);
				tmpOriginal.removeAll(tmpSet); // ������
				
				queue.add(new Node(tmpOriginal, value,1));
			}
			count = 0;
		}
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			begin = tmp.current; //���� �����ϴ� ���ڿ�
			it = tmp.set.iterator();

			if(target.equals(begin))
				return tmp.count;
			while (it.hasNext()) {
				String value = (String) it.next();
				for (int i = 0; i < begin.length(); i++) {
					if (value.charAt(i) != begin.charAt(i))
						count++; // �ٸ� ���� ���� �Ǵ�.
				}
				if (count == 1) {
					// �Ѱ��� �ٸ� ���
					Set<String> tmpOriginal = new HashSet<>(tmp.set);
					Set<String> tmpSet = new HashSet<>();
					tmpSet.add(value);
					tmpOriginal.removeAll(tmpSet); // ������
					int tmpCount = tmp.count;
					queue.add(new Node(tmpOriginal, value, tmpCount+1));
				}
				count = 0;
			}
		}
		return -1;
	}

	public static class Node {
		Set<String> set; // ���� �Ѿ�ߵ� ��ϵ�
		String current;
		int count =0 ;
		public Node(Set<String> set, String c, int count) {
			this.current = c;
			this.set = new HashSet<>(set);
			this.count =count;
		}
	}
}