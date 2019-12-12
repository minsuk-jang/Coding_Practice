package programmers1;

//����Ʈ ����, 53��, 7�� Ʋ��

import java.util.*;

public class problem_6 {
	public static void main(String[] args) {
		String tmp [] = {"classic","pop","classic","classic","pop","jazz"};
		int t[] = {500,600,150,800,2500,300};
		int [] result = solution(tmp,t);
		for(int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(String[] genres, int[] plays) {
		Map<String,Integer> map = new HashMap<>(); //�帣�� ���� ��� Ƚ�� ����
		Map<Integer,PriorityQueue<Node>> map1 = new HashMap<>();
		for(int i =0 ; i< genres.length ; i++) {
			String genre = genres[i]; //�帣
			int play=  plays[i]; //�÷��� Ƚ��
			
			if(map.get(genre) == null) {
				//ó�� ����̶��
				map.put(genre, play);
			}else
			{
				int tmp = map.get(genre);
				map.put(genre, tmp+play); //����
			}
		}
		
		List<Node> list = new LinkedList<>();
		
		for(int i =0 ; i< genres.length ; i++) {
			
			int genre = map.get(genres[i]);
			int play = plays[i];
			
			if(map1.get(genre) == null)
			{
				PriorityQueue<Node> tmpList = new PriorityQueue<>(new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						if(o1.play < o2.play) //�÷��̼��� ��������
							return 1;
						else if(o1.play == o2.play)
						{
							if(o1.idx < o2.idx) //�ε����� ��������
								return -1;
							else
								return 1;
						}else
							return -1;
					}
					
				});
				tmpList.add(new Node(play,i));
				map1.put(genre, tmpList);
			}
			else {
				PriorityQueue<Node> tmpList = map1.get(genre);
				tmpList.add(new Node(play,i));
				map1.put(genre, tmpList);
			}
		}
		
		Iterator it = map1.keySet().iterator();
		List<Integer> keyList = new LinkedList<>();
		
		while(it.hasNext()) {
			int tmp = (int)it.next();
			keyList.add(tmp);
		}
		
		keyList.sort(Collections.reverseOrder()); //������������ ����
		Vector<Integer> v = new Vector<>();
		
		for(int i =0 ; i< keyList.size(); i++) {
			PriorityQueue<Node> tmpList = map1.get(keyList.get(i));//����Ʈ�� �����´�.
			int idx = 0;
			
			while(!tmpList.isEmpty()) {
				if(idx == 2)
					break;
				v.add(tmpList.poll().idx);
				idx++;
			}
		}
		
		int tmp [] = new int[v.size()];
		for(int i =0 ; i< v.size() ; i++) {
			tmp[i] = v.get(i);
		}
		return tmp;
	}
	
	private static class Node{
		int play; //�÷��� Ƚ��
		int idx; //������ȣ
		public Node(int p ,int i) {
			this.play = p;
			this.idx = i;
		}
	}
}