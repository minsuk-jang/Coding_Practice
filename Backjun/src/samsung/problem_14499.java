package samsung;
//�ֻ��� ������

import java.io.*;
import java.util.*;

public class problem_14499 {
	static int[][] map;
	static int[] dice;
	static int diceX, diceY; // �ֻ��� ��ǥ
	static int x, y;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		dice = new int[6]; // �ֻ���
		try {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map = new int[x][y]; // �� ����
			// �ֻ��� ��ǥ ����
			diceX = Integer.parseInt(st.nextToken());
			diceY = Integer.parseInt(st.nextToken());
			int operation = Integer.parseInt(st.nextToken()); // ���ɾ� ��
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // map�� �� ����
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < operation; i++) {
				// ����
				int where = Integer.parseInt(st.nextToken()); // ����
				// ���⿡ ���� ��ġ ����
				int nx =0, ny = 0;
				switch (where) {
				case 1: {
					// ��
					ny = diceY + 1;
					nx = diceX;
					break;
				}
				case 2: {
					// ��
					ny = diceY - 1;
					nx =diceX;
					break;
				}
				case 3: {
					// ��
					nx = diceX - 1;
					ny =diceY;
					break;
				}
				case 4: {
					// ��
					nx = diceX + 1;
					ny = diceY;
					break;
				}
				}
				
				if(isPossible(nx,ny))
				{
					//���� ���� ���� �� ���
					moveDice(nx,ny,where);
					System.out.println(dice[4]);
					diceX = nx;
					diceY = ny;
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isPossible(int nx, int ny) {
		if (nx >= x || ny >= y|| nx < 0 || ny < 0) // �ܰ��� ���
			return false;
		return true;
	}
	public static void moveDice(int x,int y, int where) {
		/*
		 * dice[0] = ��, dice[1]= ��, dice[2]= ��, dice[3]=��, dice[4]= ��,dice[5]= ��
		 */
		Deque<Integer> queue = new ArrayDeque<>();
		int first=0,second=0,thrid=0,forth=0;
		switch(where) {
		case 1:
		{
			//��
			first = 5;
			second = 2;
			thrid = 4;
			forth = 3;
			break;
		}
		case 2:
		{
			//��
			first = 5;
			second = 3;
			thrid = 4;
			forth = 2;
			break;
		}
		case 3:
		{
			//��
			first = 5;
			second = 0;
			thrid = 4;
			forth = 1;
			break;
		}
		case 4:{
			//��
			first = 5;
			second = 1;
			thrid = 4;
			forth = 0;
			break;
		}
		}
		queue.add(dice[first]);
		queue.add(dice[second]);
		queue.add(dice[thrid]);
		queue.add(dice[forth]);
		
		swap(queue); //��ȯ
		save(first,second,thrid,forth,queue); //��ȯ�� �� ����
		if(map[x][y] == 0)
		{//�̵��� ĭ�� ���� �ִ� ���� 0�� ���, �ֻ��� �ٴڸ鿡 ���� �ִ� ���� ĭ�� ����
			map[x][y] = dice[5];
		}else {
			//�ƴ� ���, ĭ�� ���� �ִ� ���� �ֻ����� �ٴڸ鿡 ����Ǹ�, ĭ�� ���� �ִ� ���� 0�̵�
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
	}
	public static void swap(Deque<Integer> queue) {
		int last = queue.pollLast();
		queue.addFirst(last);
	}
	public static void save(int f1, int s, int t, int f4, Deque<Integer> queue) {
		//��ȯ�� �� ����
		dice[f1]=queue.pollFirst();
		dice[s] = queue.pollFirst();
		dice[t]= queue.pollFirst();
		dice[f4]= queue.poll();
	}
	

}