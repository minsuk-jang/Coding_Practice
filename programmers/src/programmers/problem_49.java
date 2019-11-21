package programmers;

//����
import java.util.*;

public class problem_49 {

	public static void main(String[] args0) {
		String[][] tmp = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
				{ "green_turban", "headgear" }, { "crow_mask", "face" }, { "blue_sunglasses", "face" },
				{ "smoky_makeup", "face" }  };
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i =0 ; i < clothes.length ; i++) {
			if(map.get(clothes[i][1]) == null) {
				map.put(clothes[i][1], 1);
			}
			else
			{
				int count = map.get(clothes[i][1]);
				map.put(clothes[i][1], count+1); //����
			}
		}
		
		Iterator it = map.keySet().iterator();
		int sum =1;
		while(it.hasNext()) {
			String key = (String)it.next();
			int count = map.get(key);
			sum *= (count+1);
		}
		
		return sum-1;
	}

}
