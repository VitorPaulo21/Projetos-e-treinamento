package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class mapListTest {

	
	public static void main(String[] args) {
		
		mapList map = new mapList();
		
		map.add("hey", "dois");
		System.out.println(map.get("hey", 0));
		map.put("now", "tres", 0);
		System.out.println(map.get("now", 0));
		map.put("now", "quatro", 0);
		System.out.println(map.get("now", 0));
	}
}
