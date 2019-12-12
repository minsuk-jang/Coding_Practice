package samsung;
//������ �����ֱ�

import java.io.IOException;
import java.util.*;
import java.io.*;

public class problem_14888 {
	static long big, small;
	static int N;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] op = new int[4]; // �������� ������ �ִ� �迭
		Deque<Long> queue = new LinkedList<>(); // ���� ��� ���� ť

		Queue<Node> q = new LinkedList<>(); // BFS�� �����ϱ� ���� ť

		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				queue.add(Long.parseLong(st.nextToken())); // �� ����
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				op[i] = Integer.parseInt(st.nextToken());

			br.close();
			long f = queue.poll();
			long e = queue.poll();

			for (int i = 0; i < 4; i++) {
				if (op[i] != 0) {
					long value = 0;
					switch (i) {
					case 0:
						value = f + e;
						break;
					case 1:
						value = f - e;
						break;
					case 2:
						value = f * e;
						break;
					case 3:
						if(f < 0) {
							//������ ���
							f *= -1; //����� �ٲ�
							value = f/ e; //�������� ����
							value *= -1;  //���� ������
						}else
							value = f / e; // ���� ��
						break;
					}
					queue.addFirst(value); // ���� ���� �� �� �տ� �߰�
					op[i] -= 1; // ���� ����
					Node tmp = new Node(value, queue, op);
					queue.pollFirst();
					op[i] +=1;
					q.add(tmp);
				}
			}
			long big = Long.MIN_VALUE, small = Long.MAX_VALUE;

			while (!q.isEmpty()) {
				Node current = q.poll();
				if (isFinish(current.op)) {
					// ��� �����ڸ� �� ����� ���
					big = Math.max(big, current.value);
					small = Math.min(small, current.value);
				} else {
					long opr1= current.queue.poll();
					long opr2 = current.queue.poll();

					for (int i = 0; i < 4; i++) {
						if (current.op[i] != 0) {
							long value = 0;
							switch (i) {
							case 0:
								value = opr1 + opr2;
								break;
							case 1:
								value = opr1 - opr2;
								break;
							case 2:
								value = opr1 * opr2;
								break;
							case 3:
								if(opr1 < 0) {
									//������ ���
									opr1 *= -1; //����� �ٲ�
									value = opr1/ opr2; //�������� ����
									value *= -1;  //���� ������
								}else
									value = opr1 / opr2; // ���� ��
								break;
							}
							current.queue.addFirst(value); // ���� ���� �� �� �տ� �߰�
							current.op[i] -= 1; // ���� ����
							Node tmp = new Node(value, current.queue, current.op);
							current.queue.pollFirst();
							current.op[i] +=1;
							q.add(tmp);
						}
					}
				}
			}

			System.out.println(big);
			System.out.println(small);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isFinish(int[] op) {
		for (int i = 0; i < 4; i++)
			if (op[i] != 0)
				return false;

		return true;
	}

	private static class Node {
		long value;
		Deque<Long> queue;
		int[] op;

		public Node(long v, Deque<Long> q, int[] op) {
			this.value = v;
			this.queue = new LinkedList<>(q);
			this.op = new int[4];
			System.arraycopy(op, 0, this.op, 0, op.length);
		}
	}
}