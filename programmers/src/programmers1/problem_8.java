package programmers1;

//2020 kakao �ڹ���� ���� 81��

public class problem_8 {
	public static void main(String[] args) {
		int [][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int [][] lock = {{1,1,0},{1,1,0},{1,0,1}};
		
		boolean result = solution(key,lock);
		System.out.println(result);
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int count =0 ;//lock�� Ȩ�� ����
		
		for(int i =0 ; i< lock.length ;i++) {
			for(int j =0 ; j< lock[i].length ; j++)
				if(lock[i][j] == 0)
					count++;
		}
		
		for(int i = 0 ; i< 4 ; i++) {
			//ȸ�� Ƚ��
			for(int j = -key.length+1 ; j< lock.length ; j++) {
				for(int k = -key.length+1 ; k < lock.length ; k++) {
					if(isPossible(j,k,key,lock,count)) {
						answer = true;
						return answer;
					}
						
				}
			}
			key = rotation(key);
		}
		
		return answer;
	}

	public static int[][] rotation(int [][] key) {
		int [][] tmp = new int[key.length][key.length];
		int idx = 0;
		
		for(int i =0 ; i< key.length ; i++) {
			for(int j =0 ; j< key[i].length ; j++) {
				if(key[i][j] == 1) {
					//90 degree rotation
					int nx = j;
					int ny = (key.length - 1 - i);
					tmp[nx][ny] = 1;
				}
			}
		}
		
		return tmp;
	}
	/*
	 * �ڹ��� ������ ��� �κп� �ִ� ������ Ȩ�� ����� �ڹ��踦 ���µ� ������ ���� ������,
	 * �ڹ��� ������������ ������ ���� �κа� �ڹ����� Ȩ �κ��� ��Ȯ�� ��ġ�ؾ� �ϸ� ������ ����� �ڹ����� ���Ⱑ �������� �ȵȴ�.
	 * ���� �ڹ����� ��� Ȩ�� ä�� ����ִ� ���� ����� �ڹ��踦 �� �� �ֽ��ϴ�.
	 */
	public static boolean isPossible(int x, int y, int[][] key, int [][] lock,int count) {
		for(int i =0 ; i< key.length ; i++) {
			for(int j = 0 ; j< key.length ; j++) {
				int tmpX = x+i, tmpY = y + j; //��ǥ
				if(tmpX < 0 || tmpY < 0 || tmpX >= lock.length || tmpY >= lock.length)
					continue; //������ ���� �� ���
				
				//�ڹ��� ������
				if(key[i][j] == 1 && lock[tmpX][tmpY] == 1)
					return false; //�� �� ���Ⱑ ������ ���
				if(key[i][j] == 1 && lock[tmpX][tmpY] == 0)
					count--; //������ ����� �ڹ����� Ȩ
			}
		}
		if(count == 0)
			return true;
		return false;
	}
}

