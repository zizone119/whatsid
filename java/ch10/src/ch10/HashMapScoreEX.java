package ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEX {

	public static void main(String[] args) {
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		scoreMap.put("aaa",97);
		scoreMap.put("bbb",63);
		scoreMap.put("ccc",73);
		scoreMap.put("ddd",11);
		scoreMap.put("eee",87);
		System.out.println(scoreMap.size());
		Set<String> keys = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name+" "+score);
		}
	}

}
