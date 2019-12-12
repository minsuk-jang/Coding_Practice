package dijkstra;
//�ּ� ���
import java.io.*;
import java.util.*;
public class problem_1916 {
	public static void main(String[] args0) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Node> queue= new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.distance < o2.distance)
					return -1;
				else
					return 1;
			}
			
		});
		int dist[] = null;
		int INF = Integer.MAX_VALUE;
		List<Node>[] list = null; //���� ����Ʈ
		int n =0 , m=0, start =0, end = 0; 
		try {
			st =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); //������ ����
			dist = new int[n+1];
			Arrays.fill(dist, INF);
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); //������ ����
			
			list = new ArrayList[n+1]; 
			
			for(int i =1 ; i<= n ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i =0 ; i <  m ;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()); //������
				int e = Integer.parseInt(st.nextToken()); //����
				int w = Integer.parseInt(st.nextToken()); //����ġ
				
				list[s].add(new Node(e,w));
			}
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			dist[start] = 0;
			
			end = Integer.parseInt(st.nextToken());
			br.close();
			queue.add(new Node(start,0)); //�������� �켱���� ť�� �ִ´�.
			
			while(!queue.isEmpty()) {
				Node tmp = queue.poll();
				int idx=  tmp.idx;
				int distance = tmp.distance;
				for(Node ne : list[idx]) {
					//�ش� �ε����� ������ ������ �ҷ��´�.
					int nextIdx = ne.idx;
					int nextDistance = dist[idx] + ne.distance; //���� ���� ����� ��� 
					if(nextDistance < dist[nextIdx]) {
						//���� ��뺸�� ���İ��� ����� �ּ� ����� ���
						dist[nextIdx] = nextDistance;
						queue.add(new Node(nextIdx,dist[nextIdx]));
					}
					
				}
			}
			
			System.out.println(dist[end]);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private static class Node{
		int idx =0, distance= 0;
		public Node(int i, int dist) {
			this.idx = i;
			this.distance = dist;
		}
	}
}