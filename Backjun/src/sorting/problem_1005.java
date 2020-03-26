package sorting;

//ACM Craft
import java.util.*;
import java.io.*;

public class problem_1005 {
	static int[] indegree;
	static int[] time;
	static List<Integer> list[];
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			indegree = new int[N];
			time = new int[N];
			list = new ArrayList[N];

			st = new StringTokenizer(br.readLine());
			// �ʱ�ȭ
			for (int j = 0; j < N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
				list[j] = new ArrayList<>();
			}

			// �ǹ����� �����ϴ� ����
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;

				list[s].add(e);
			}

			// �¸��� ���ؼ� ������� �ǹ�
			int want = Integer.parseInt(br.readLine())-1;

			topology_sort(want);
		}
	}

	private static void topology_sort(int want) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//������ ������ ������ ������Ų��.
		for(int i =0 ; i< N ; i++) {
			for(int j = 0 ; j< list[i].size() ; j++) {
				int target = list[i].get(j);
				indegree[target]++;
			}
		}
		
		//������ ������ 0�� ������ ť�� �ִ´�.
		for(int i =0 ; i < N ; i++) {
			if(indegree[i] == 0)
				pq.add(new Node(i,time[i]));
		}
		
		
		//������ ������ŭ �ݺ����� �����Ѵ�.
		for(int i =0 ; i< N ; i++) {
			if(pq.isEmpty()) {
				break;
			}
			
			Node cur = pq.poll();
			int curIdx = cur.number;
			int curTime = cur.time;
			//���� �������� ������ ������ �����.
			for(int j = 0 ; j< list[curIdx].size() ; j++) {
				int next = list[curIdx].get(j);
				
				indegree[next]--;
				if(indegree[next] == 0) {
					time[next] += curTime;
					pq.add(new Node(next,time[next]));
				}
			}
		}
		
		System.out.println(time[want]);
	}

	// ���� �ǹ��� ��ȣ�� �ϼ��Ǵ� �ð��� �����ϴ� Ŭ����
	private static class Node implements Comparable<Node> {
		int number;
		int time;

		public Node(int n, int t) {
			this.number = n;
			this.time = t;
		}

		// �ð��� ������� ���������� �����Ѵ�.
		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			if (this.time < arg0.time) {
				return -1;
			} else
				return 1;
		}

	}
}