package ch10;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lm = new LinkedHashMap<String, Integer>();
		lm.put("aaa",11);
		lm.put("bbb",14);
		lm.put("ccc",22);
		lm.put("ddd",52);
		lm.put("eee",88);
		System.out.println(lm+total_avg(lm));
	}
	public static String total_avg(Map m) {
		int total=0;
		int cnt = m.size();
		Collection<Integer> c = m.values();
		Iterator<Integer> it = c.iterator();
		while(it.hasNext()) {
			total+=it.next();
		}
		return " "+total+" "+ (double)total/cnt;
	}

}
