package programmers1;

//���� ��ȣ
public class problem_46 {
	public static void main(String[] args) {
		String s = "a B z";
		String result = solution(s, 4);
		System.out.println(result);
	}

	public static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		char[] array = new char[26];

		for (int i = 0; i < 26; i++) {
			int c = (int) 'a';
			c += i;
			array[i] = (char) c;
		}

		for (int i = 0; i < s.length(); i++) {
			int c = 0;
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') // �ҹ��� �� ���
			{
				int t = ((int) s.charAt(i) + n) % 'a';
				c = array[t % 26];
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') // �빮�� �� ���
			{
				int t = ((int) s.charAt(i) + n) % 'A';
				c = Character.toUpperCase(array[t % 26] );
			} else
				c = s.charAt(i);
			sb.append((char) c); // ����ȯ
		}

		return sb.toString();
	}
}