package samsung_Atype;

//�߱���
import java.util.*;
import java.io.*;

public class problem_17281 {
	static int inning;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inning = Integer.parseInt(br.readLine());
		Node[] players = new Node[9];
		List[] tmpList = new ArrayList[9];

		for (int i = 0; i < tmpList.length; i++)
			tmpList[i] = new ArrayList<>();

		for (int i = 0; i < inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tmpList.length; j++) {
				tmpList[j].add(Integer.parseInt(st.nextToken()));
			}
		}

		// �����鿡 ���� ���� ����
		for (int i = 0; i < players.length; i++) {
			players[i] = new Node(tmpList[i], i);
		}

		int depth = 1;
		long start = System.currentTimeMillis();
		dfs(depth, players);
		long end = System.currentTimeMillis();
		System.out.println("total time : " + (end - start) / 1000.0);
		System.out.println(answer);
	}

	private static void dfs(int depth, Node[] players) {
		if (depth == players.length) {

			int value = 0;
			Queue<Node> player = null;
			List<Node> tmp = new ArrayList<>();

			for (int i = 1; i < players.length; i++) {
				if (i == 4)
					tmp.add(players[0]);
				tmp.add(players[i]);
			}

			player = new LinkedList<>(tmp);
		
			for (int i = 0; i < inning; i++) {
				value += startGame(player, i);
			}
			answer = Math.max(value, answer);

			return;
		}

		for (int i = depth; i < players.length; i++) {
			swap(depth, i, players);
			dfs(depth + 1, players);
			swap(i, depth, players);
		}
	}


	private static int startGame(Queue<Node> player, int inning) {
		int point = 0;
		int outCount = 0;
		int basePlayer = 0;
		int base[] = new int[3];
		
		// �ƿ� ī��Ʈ�� 3�� �Ǹ� ���� �̴����� �Ѿ��.
		while (outCount != 3) {
			Node currentPlayer = player.poll();
			int action = currentPlayer.innings.get(inning);

			if (action == 0) { //�ƿ� ������ ���
				outCount += 1;
			} else if (action == 4) { //Ȩ���� ���� ���
				if(basePlayer != 0) {
					point += basePlayer;
					basePlayer = 0;
					Arrays.fill(base, 0);
				}
				point++;
			} else {
				for(int i = 2 ; i >= 0 ; i --) {
					if(base[i] != 0)
					{
						base[i] += action;
						if(base[i] >= 4) {
							point++;
							base[i] = 0;
							basePlayer--;
						}
						else {
							base[base[i]-1] = base[i];
							base[i] = 0;
						}
					}
				}
				base[action-1] = action;
				basePlayer++;
			}
			//��ȯ ������ ������ ���ؼ� ���� ����� ����� �ִ´�.
			player.add(currentPlayer);
		}

		return point;

	}

	private static void swap(int depth, int i, Node[] players) {
		// 4�� Ÿ�ڴ� ������ �ִ�.
		Node tmp = players[depth];
		players[depth] = players[i];
		players[i] = tmp;
	}

	private static class Node {
		List<Integer> innings;
		int number;

		public Node(List<Integer> in, int n) {
			this.innings = new ArrayList<>(in);
			this.number = n;
		}
	}

}