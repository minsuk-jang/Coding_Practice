package others;

/*
 * �м��� �Ҽ���
 * ���� + ������ ������ �̿��ؼ� ������ �ذ��Ѵ�.
 * ��ȯ�Ҽ��� Key ����Ʈ�� �ѹ� �湮�� �������� �ٽ� �湮�� ���, ��ȯ�� �߻��Ѵٴ� ���̴�.
 * ������ ������ 0<= <= 1024�̹Ƿ� �湮 äũ���ϱ� ���� �迭�� ũ�⸦ 1024�� �����Ͽ� �����Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_11571 {
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			simulation(c, p); //���ڰ� 0�� ���� ������ �ƴ�
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void simulation(int c, int p) throws IOException {
		StringBuilder sb = new StringBuilder();
		int[] visited = new int[1025];
		Arrays.fill(visited, -1);

		sb.append(c / p + ".");

		c = c % p; // ������

		int seq = sb.indexOf(".");
		visited[c] = seq++;

		while (true) {
			c *= 10;

			int div = c / p;
			int mod = c % p;

			sb.append(div);

			if (visited[mod] != -1) {
				// ��ȯ�Ǵ� ����
				sb.insert(visited[mod] + 1, "(");
				sb.append(")");
				bw.write(sb.toString());
				bw.newLine();
				break;
			}

			visited[mod] = seq++;
			c = mod;
		}

	}

}