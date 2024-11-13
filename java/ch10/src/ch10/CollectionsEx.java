package ch10;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsEx {

	static void printList(LinkedList<String> l) {
		Iterator<String> it = l.iterator();
		while(it.hasNext()) {
			String e = it.next();
			String sepeator;
			if(it.hasNext()) sepeator = "->";
			else sepeator = "\n";
			System.out.print(e+sepeator);
		}
	}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("aaa");
		myList.add("bbb");
		myList.add("fff");
		myList.add("ddd");
		myList.add("eee");
		Collections.sort(myList);
		printList(myList);
		Collections.reverse(myList);
		printList(myList);
		int idx = Collections.binarySearch(myList, "ddd")+1;
		System.out.println(idx);
	}
}
