package programmers;

//N으로 표현 28.6 -> 57.1
//현재 방법의 문제점 => 2와 1의 조합은 상관 업으나 4부터 문제
//만약 4일 경우, 2와 2의 경우, 3과 1의 경우가 다발생
import java.util.*;

public class problem_10 {
	public static void main(String[] args) {
		int result = solution(2, 11);
		System.out.println(result);
	}

	public static int add(int x, int y) {
		return x + y;
	}

	public static int sub(int x, int y) {
		return x - y;
	}

	public static int mul(int x, int y) {
		return x * y;
	}

	public static int div(int x, int y) {
		if (y != 0)
			return x / y;
		return 0;
	}

	public static int solution(int N, int number) {
		ArrayList<ArrayList> totalList = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>(); // 중복 제거를 위해서 사용
		for (int i = 0; i <= 9; i++) {
			ArrayList<Integer> semi = new ArrayList<>();
			totalList.add(semi); // 각 자리수에 리스트 배열 추가
		}
		int tmp = 0;
		for (int i = 1; i <= 9; i++) {
			tmp += N * (int) Math.pow(10, i-1);
			ArrayList t = totalList.get(i);
			t.add(tmp); // 자리수 위치에 값 추가
			set.add(tmp);
			if(set.contains(number))
				return i;
		}
		

		for (int i = 2; i <= 8; i++) { //전체 자리수
			for (int j = i - 1; j >= 1; j--) {
				ArrayList t1 = totalList.get(j);
				ArrayList t2 = totalList.get(i - j);

				for (int k = 0; k < t1.size(); k++) {
					for (int l = 0; l < t2.size(); l++) {
						int result1 = add((int) t1.get(k), (int) t2.get(l));
						if (!set.contains(result1)) {
							set.add(result1);
							ArrayList tmp1 = totalList.get(i);
							tmp1.add(result1);
						}
						int result2 = sub((int) t1.get(k), (int) t2.get(l));
						if (!set.contains(result2)) {
							set.add(result2);
							ArrayList tmp1 = totalList.get(i);
							tmp1.add(result2);
						}
						int result3 = mul((int) t1.get(k), (int) t2.get(l));
						if (!set.contains(result3)) {
							set.add(result3);
							ArrayList tmp1 = totalList.get(i);
							tmp1.add(result3);
						}
						int result4 = div((int) t1.get(k), (int) t2.get(l));
						if (!set.contains(result4)) {
							set.add(result4);
							ArrayList tmp1 = totalList.get(i);
							tmp1.add(result4);
						}
					}
				}
				if(set.contains(number))
					return i;
			}
		}

		return -1;
	}
}
