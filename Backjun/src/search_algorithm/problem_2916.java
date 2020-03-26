package search_algorithm;

//�ڿ� ������
import java.util.*;
import java.io.*;

public class problem_2916 {
	static List<Integer> angle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		angle = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			angle.add(Integer.parseInt(st.nextToken()));
		
		canMakeAngle();

		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (angle.contains(target)) {
				System.out.println("YES");
			}else
				System.out.println("NO");
		}
	}

	private static void canMakeAngle() {
		while (true) {
			int size = angle.size();

			for (int i = 0; i < size; i++) {
				makeNewAngle(1, angle.get(i), size);
			}
			if (size == angle.size())
				break;
		}
		
	}

	private static void makeNewAngle(int depth, int value, int size) {
		if (depth == 2) {
			int a = Math.floorMod(value, 360);
			// ������� �������� �ƴ��� �Ǻ�
			if (!angle.contains(a)) {
				// �������� ���� ��쿡�� �ش� ���� �ִ´�.
				angle.add(a);
			}
			return;
		}

		for (int i = 0; i < size; i++) {
			makeNewAngle(depth + 1, value + angle.get(i), size);
			makeNewAngle(depth + 1, value - angle.get(i), size);
		}
	}
}