package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//삽입삭제가 빠르다
public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1 직접리스트에서 가져오기
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		//삭제
		list.remove(2);
		System.out.println("=================");
		
		//순회2 collection framework에서 쓰는 방법
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("=================");
		//순회3
		for(String s : list) {
			System.out.println(s);
		}

	}

}
