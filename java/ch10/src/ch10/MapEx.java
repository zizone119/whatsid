package ch10;

import java.util.HashMap;

import java.util.Iterator;

public class MapEx {

	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("이병일","987643");
		hm.put("bts", "345659");
		hm.put("로제", "987643");
		
		Iterator<String> it =hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		System.out.println(hm.values());
		Iterator<String> i = hm.values().iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
