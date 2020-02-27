package bruteForce;

//���� ����
import java.util.*;
import java.io.*;

public class problem_10973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());
		

		int value = array[0];
		boolean check = false;
		
		for (int i = 1; i < N; i++) {
			if (value < array[i]) {
				value = array[i];
			} else {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println(-1);
		} else {
			permutation(array);
		}
	}

	private static void permutation(int[] array) {
		int idx = array.length - 1; // ���� ������ �� �ڸ���
		boolean visited[] = new boolean[array.length];

		Arrays.fill(visited, true);
		boolean check = false;
		
		while (true) {
			int cur = array[idx];
			visited[cur - 1] = false;
			
			//������ ���� �湮�� ���� ���°��� Ȯ��
			for (int i = cur - 2; i >= 0; i--) {
				if (!visited[i]) {
					check = true;
					break;
				}
			}

			if (check) {
				cur = array[idx];
				for (int i = cur - 2; i >= 0; i--) {
					if (!visited[i]) {
						visited[i] = true;
						array[idx] = i + 1;
						break;
					}
				}
				for (int j = idx + 1; j < array.length; j++) {
					for (int i = visited.length - 1; i >= 0; i--) {
						if (!visited[i]) {
							visited[i] = true;
							array[j] = i + 1;
							break;
						}
					}
				}
				break;
				
			}
			idx--;
		}
		for(int i =0 ; i< array.length ; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}