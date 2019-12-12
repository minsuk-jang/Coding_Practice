package palindrome;

import java.io.BufferedReader;
import java.io.IOException;

//���� �� �Ӹ����
import java.io.*;
import java.util.*;

public class problem_13275 {
	public static void main(String[] args0) {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int big = 0 , rightBoundary =0 , center = 0;
		int [] p = null;
		try {
			String s = getModifiedString(br.readLine()); //manacher �˰������� �����ϱ� ���� ������ ���ڿ�
			p = new int[s.length()];
			for(int i = 0 ; i< s.length() ; i++) {
				int mirror = 2*center -i; //mirror ��
				
				if(i < rightBoundary)
					p[i] = Math.min(rightBoundary - i, p[mirror]); 
				
				//���� �������� ����, �������� Ȯ��
				int left = i-(p[i]+1);
				int right = i+(p[i]+1);
				
				//Ȯ��
				while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
					p[i]++;
				}
				
				//���� ��輱�� ����� �� ����
				if(i+p[i] > rightBoundary) {
					center = i;
					rightBoundary = i + p[i];
					big = Math.max(big, p[i]);
				}
			}

			System.out.println(big);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static String getModifiedString(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		for(int i =0 ; i< s.length() ; i++) {
			sb.insert(i+i,'#'); //���ڿ� ���̻��̿� # ����
		}
		
		sb.append('#');
		
		return sb.toString();
		
	}
}