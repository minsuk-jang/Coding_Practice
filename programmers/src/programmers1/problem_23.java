package programmers1;

//�ټ��� ��

import java.util.*;

public class problem_23 {
	public static void main(String[] args) {
		int[] result = solution(4,14);
		for(int i : result) {
			System.out.print(i+ " ");
		}
	}

	public static int[] solution(int n, long k) {
		Queue<Integer> pq = new LinkedList<>();
		
		for(int i =0 ; i< n ; i++)
			pq.add(i +1); //������������ �Ҵ�
		
		int[] answer = new int[n];
		int idx =0 ;
		
		while(!pq.isEmpty()) {
			int value = pq.poll();
			long size = calSize(pq.size());
			if(k - size > 0) {
				//��� �� ���
				k -= size;
				pq.add(value); //���� ���� �� �ֱ�
			}
			else if(k -size < 0) {
				//���� �� ���
				answer[idx++] = value; //���� �� �ֱ�
				pq = upSort(pq);
			}
			else {
				//0�� ���
				answer[idx++] = value;
				pq = downSort(pq);
				while(!pq.isEmpty()) {
					answer[idx++] = pq.poll();
				}
			}
		}
		return answer;
	}
	private static Queue<Integer> downSort(Queue<Integer>pq){
		List<Integer> list = new ArrayList<>(pq);
		list.sort(Collections.reverseOrder());
		Queue<Integer> q = new LinkedList<>(list);
		
		return q;
	}
	
	private static Queue<Integer> upSort(Queue<Integer> pq){
		TreeSet<Integer> set = new TreeSet<>(pq);
		Queue<Integer> pq1 = new LinkedList<Integer>(set);
		return pq1;
	}
	
	private static long calSize(int v) {
		if(v == 1)
			return 1;
		
		return v * calSize(v-1);
	}
}