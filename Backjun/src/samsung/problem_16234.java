package samsung;

//�α� �̵�
import java.util.*;
import java.io.*;

public class problem_16234 {
	static int N, L,R;
	static int[][] map;
	static boolean [][] visited;
	static int[] ud = {-1,0,1,0};
	static int[] rl = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i =0 ; i < N ; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j =0 ; j <N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start();
	}
	private static void start() {
		int moveCount = 0;
		List<Set<List<Integer>>> totalUnited = new ArrayList<>();
		while(true) {
			
			for(int i =0 ; i < N ; i++) {
				for(int j =0 ; j <N ; j++) {
					if(!visited[i][j]) {
						Set<List<Integer>> united = new HashSet<>();
						findUnited(i,j,united);
						if(!united.isEmpty())
							totalUnited.add(united);
					}
				}
			}
			
			if(totalUnited.isEmpty())
				break;
			
			movePeople(totalUnited);
			totalUnited.clear();
			
			visited = new boolean[N][N];
			moveCount++;
		}
		
		System.out.println(moveCount);
	}
	
	private static void movePeople(List<Set<List<Integer>>> totalUnited) {
		for(int i =0 ; i < totalUnited.size() ; i++) {
			Set<List<Integer>> tmp = totalUnited.get(i);
			int unitedPeople = 0;

			Iterator<List<Integer>> it = tmp.iterator();
			while(it.hasNext()) {
				List<Integer> cur = it.next();
				int x = cur.get(0);
				int y = cur.get(1);
				
				unitedPeople += map[x][y];
			}
			//������ �α��� / ������ �̷�� �ִ� ĭ�� ����
			unitedPeople /= tmp.size();
			
			//�� ����
			it = tmp.iterator();
			while(it.hasNext()) {
				List<Integer> cur = it.next();
				int x = cur.get(0);
				int y = cur.get(1);
				
				map[x][y] = unitedPeople;
			}
		}
	}
	
	private static void findUnited(int x ,int y,Set<List<Integer>> set) {
		visited[x][y] = true;
		for(int i =0 ; i <4 ; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];
			
			//������ ��� ���� �ѹ��̶� �湮�� ���� ���
			if(nx <0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
				continue;
			
			int diff = Math.abs(map[x][y] - map[nx][ny]);
			
			//���� ������ ������ �α��� ���̰� L �̻� R���� �� ���
			if(diff >= L && diff <= R) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(x);
				tmp.add(y);
				
				set.add(tmp);
				
				tmp = new ArrayList<>();
				tmp.add(nx);
				tmp.add(ny);
				
				set.add(tmp);
				findUnited(nx,ny,set);
			}
		}
	}
}