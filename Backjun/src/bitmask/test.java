package bitmask;

public class test {
	public static void main(String[] args) {
		int result = (1 << 3);
		System.out.println(result);

		for (int i = 0; i < 2; i++) {
			if ((result & 1 << i) == 0 << i)
				System.out.println(1);
			else
				System.out.println(2);
		}
	}

}
