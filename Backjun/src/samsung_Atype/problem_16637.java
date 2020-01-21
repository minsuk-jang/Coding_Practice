package samsung_Atype;

//��ȣ �߰��ϱ�

import java.util.*;
import java.io.*;

public class problem_16637 {
	static int value = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine(); // ����
		br.close();
		StringBuilder sb = new StringBuilder(line);
		int depth = 1;
		dfs(depth, line, sb);
		System.out.println(value);
	}

	private static void dfs(int depth, String line, StringBuilder sb) {
		if (depth >= sb.length()) {
			// ���� ��ǥ�� �־��� �ĺ��� ���̰� �� ���
			calculate(sb.toString());
			return;
		}

		/*
		 * ��ȣ�� �ִ� ���� ��ȣ�� ���� ��츦 �����Ѵ�. ���� ��ȣ�� �ִ� ���
		 */
		StringBuilder tmpSb = new StringBuilder(sb.toString());
		sb.insert(depth - 1, '(');
		sb.insert(depth + 3, ')');
		dfs(depth + 6, line, sb);

		// ��ȣ�� ��찡 ���� ���
		sb = tmpSb;
		dfs(depth + 2, line, sb);

	}

	private static void calculate(String s) {
		// ����� ��ȣ �켱������ �����ϰ� ���ʺ��� ���������� ����Ѵ�.
		StringBuilder sb = new StringBuilder();

		// �Ŀ� �����ϴ� ��ȣ ���� ���
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				int left = Character.digit(s.charAt(i + 1), 10);
				char op = s.charAt(i + 2);
				int right = Character.digit(s.charAt(i + 3), 10);
				sb.append(calculate(left, right, op) +" ");
				i += 4;
			} else {
				sb.append(s.charAt(i) + " ");
			}
		}

		StringTokenizer st = new StringTokenizer(sb.toString().trim());
		Deque<String> dq = new LinkedList<>();
		while(st.hasMoreTokens()) {
			dq.add(st.nextToken());
		}
	
		while(!dq.isEmpty()) {
			if(dq.size() == 1)
				break;
			int left = Integer.parseInt(dq.pollFirst());
			char op = dq.poll().charAt(0);
			int right = Integer.parseInt(dq.poll());
			
			dq.addFirst(Integer.toString(calculate(left,right,op)));
		}
		String result = dq.poll();
		
		value = Math.max(value, Integer.parseInt(result));
	}

	private static int calculate(int v1, int v2, char op) {
		int sum = 0;
		switch (op) {
		case '+':
			sum = v1 + v2;
			break;
		case '-':
			sum = v1 - v2;
			break;
		case '*':
			sum = v1 * v2;
			break;
		case '/':
			sum = v1 / v2;
			break;
		}

		return sum;
	}
}