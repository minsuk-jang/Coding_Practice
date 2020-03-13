package greedy;

//���� ����
import java.util.*;
import java.io.*;

public class problem_1202 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		//���԰� ������ ������ ����
		PriorityQueue<Node> jewel = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.w < o2.w) {
					return -1;
				} else
					return 1;
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			jewel.add(new Node(w, v));

		}

		PriorityQueue<Integer> backpack = new PriorityQueue<Integer>();
		for (int i = 0; i < K; i++) {
			backpack.add(Integer.parseInt(br.readLine()));
		}

		long totalValue = 0;
		
		//������ ��ġ�� ������������ ����
		PriorityQueue<Integer> jewelValue = new PriorityQueue<>(Collections.reverseOrder());

		while (!backpack.isEmpty()) {
			int bag = backpack.poll(); //���� ���� ����

			//���� ���� ���Ժ��� ���� �������� �� ������.
			while (!jewel.isEmpty()) {
				if (bag >= jewel.peek().w)
					jewelValue.add(jewel.poll().v);
				else
					break;
			}

			//���� ���濡 �� �� �ִ� ������ ��, ���� ��ġ�� ū ������ ������.
			if (!jewelValue.isEmpty())
				totalValue += jewelValue.poll();

		}

		System.out.println(totalValue);
	}

	private static class Node {
		int w, v;

		public Node(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}