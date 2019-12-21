package combination;

//�ҹ��� ĥ����
import java.util.*;
import java.io.*;

public class problem_1941 {
	static boolean[][] visited; // �湮�� ���� äũ�ϱ� ���� �迭
	static int[] ud = { -1, 0, 1, 0 }; // ���Ʒ�
	static int[] rl = { 0, 1, 0, -1 }; // �翷
	static int count; // ������ �����ϴ� ����
	static char[] map;
	static boolean[] mapVisited; //������ �ϱ� ���� ����
	static int cnt; //DFS�� ������ ī��Ʈ�ϱ� ���� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[25]; // 5*5 ������ �迭
		visited = new boolean[5][5];
		
		int start = 0;
		for(int i =0  ;i < 5 ; i++) {
			start = i*5;
			System.arraycopy(br.readLine().toCharArray(), 0, map, start, 5);
		}
		mapVisited = new boolean[25];
		
		int yCount = 0, depth= 0;
		for(int i =0 ; i < 25 ; i++)
		{
			if(!mapVisited[i])
			{
				mapVisited[i] = true;
				visited[i/5][i%5] = true;
				if(map[i] == 'Y')
					yCount +=1;
				dfs(yCount,depth+1,i+1);
				if(map[i] == 'Y')
					yCount -=1;
				visited[i/5][i%5]= false;
				mapVisited[i]= false;
			}
		}
		System.out.println(count);

	}

	private static void dfs(int yCount, int depth, int next) {
		if(yCount > 3)
			return;
		
		if(depth == 7) {
			if(yCount <= 3) {
				connection(); //���� ������ִ��� �Ǵ��ϴ� �޼ҵ�
			}
			return;
		}
		
		for(int i = next ; i < 25 ; i++) {
			if(!mapVisited[i]) {
				mapVisited[i]= true;
				visited[i/5][i%5] =true;
				if(map[i] == 'Y')
					yCount += 1;
				dfs(yCount,depth+1,i+1);
				if(map[i] == 'Y')
					yCount -= 1;
				visited[i/5][i%5] = false;
				mapVisited[i] =false;
			}
		}
	}
	
	private static void connection() {
		for(int i =0 ; i < 25 ; i++) {
			if(mapVisited[i]) {
				int x = i/5;
				int y = i%5;
				boolean [][] check = new boolean[5][5];
				check[x][y] = true;
				cnt = 1;
				isConnection(x,y,check);
				cnt =0;
				return;
			}
		}
	}
	
	private static void isConnection(int x,int y, boolean [][] check) {
		if(cnt == 7) {
			count++;
			return;
		}
		
		for(int i =0 ; i< 4 ; i++) {
			int nx = x+ud[i];
			int ny = y+rl[i];
			
			if(nx <0 || ny < 0 || nx >= 5 || ny >= 5)
				continue;
			
			if(visited[nx][ny] && !check[nx][ny]) {
				check[nx][ny] = true;
				cnt +=1;
				isConnection(nx,ny,check);
			}
		}
		
	}
}