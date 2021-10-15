package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class mapList {

	ArrayList<HashMap<String,Object>> map = new ArrayList<>();
	
	void add (String key, String value) {
		
		{
			
			HashMap<String,Object> item = new HashMap<>();
			
			item.put(key, value);
			map.add(item);
			
		}
		
	}
	
	void insert (String key, String value, int pos) {
		
		{
		HashMap<String,Object> item = new HashMap<>();
		
		item.put(key, value);
		map.add(pos, item);
		
		}
	}
	
	void put (String key, String value, int pos) {
		
		map.get(pos).put(key, value);
		
	}
	
	String get (String key, int pos) {
		String val = map.get(pos).get(key).toString();
		return val;
		
	}
	
	void delete (int pos) {
		
		map.remove(pos);
		
	}
	
	void clear () {
		
		map.clear(); 
		
	}
	
	boolean contains (String key, int pos) {
		
		return map.get(pos).containsKey(key);
		
	}
	
	void sort (ArrayList<HashMap<String, Object>> listMap, String key, boolean isNumber, boolean ascending) {
		
		Collections.sort(listMap, new Comparator<HashMap<String, Object>>(){
			
			public int compare ( HashMap<String,Object>compmap1, HashMap<String,Object>compmap2) {
				
				if (isNumber) {
					
					int count1 = Integer.valueOf(compmap1.get(key).toString());
					int count2 = Integer.valueOf(compmap2.get(key).toString());
					
					if (ascending) {
						
						return count1 < count2 ? -1 : count1 < count2 ? 1 : 0;
						
					} else {

						return count1 > count2 ? -1 : count1 > count2 ? 1 : 0;
						
					}
				} else {

					if (ascending) {
						
						return (compmap1.get(key).toString()).compareTo(compmap2.toString());
						
					} else {

						return (compmap2.get(key).toString()).compareTo(compmap1.toString());
						
					}
					
				}
				
			}
			
		});
		
		     
		
		
	}
	
	void reverse (ArrayList<HashMap<String,Object>> array) {
		
		Collections.reverse(array);
		
	}
	
	 void addMap (HashMap<String,Object> mar) {
		 
		 map.add(mar);
		 
	 }
	 
	 void insertMap(HashMap<String,Object> mar, int pos) {
		 
		 map.add(pos,mar);
		 
	 }
	 
	 HashMap<String,Object> getMap (int pos){
		 
		 return map.get(pos);
		 
	 }
	 
	 void remove (int pos) {
		 
		 map.remove(pos);
		 
	 }
	 
	 int size (){
		 
		return map.size();
		 
	 }
	 
	 ArrayList<HashMap<String,Object>> call (){
		 
		 return map;
		 
	 }
	 
	 void replaceAll (String key, String value) {
		 
		 if (size()>0) {
			
			for (int i=0 ;i<size(); i++) {
				
				put(key, value, i);
				
			}
			 
		} else {

			add(key, value);
			
		}
		 
	 }
	 
	 HashMap<String,Object> getMapFromPos (int pos){
		 
		 return map.get(pos);
		 
	 }
	 
	 void posToMap (int pos, HashMap<String,Object> toMap) {
		 
		 toMap = getMapFromPos(pos);
		 
	 }
	 
	 void movePos (int fromPos, int toPos) {
		 
		 {
			 
			 HashMap<String,Object> item = new HashMap<>();
			 item = getMapFromPos(fromPos);
			 remove(fromPos);
			 insertMap(item, toPos);
			 item.clear();
		 }
		
	 }
	 
	 ArrayList<Integer> getAllKeyPos (String key, String value){
		 
		 ArrayList<Integer> list2 = new ArrayList<Integer>();
		 
		 for (int i=0; i<size(); i++) {
			
			if (contains(key, i)) {
				
				if (get(key, i).equals(value)) {
					
					list2.add(i);
					
				} else {

				}
				
				
			} else {

			}
			
		}
		 return list2;
	 }
	 
	 ArrayList<String> getAllKeyValue (String key, boolean once){
		 
		 ArrayList<String> list = new ArrayList<String>();
		 
		 
		 for (int i=0; i<size(); i++) {
			
			if (contains(key, i)) {
				if (once) {
					
					if (list.contains(get(key, i))) {
						
						
					} else {

						list.add(get(key, i));
						
					}
					
				} else {

					list.add(get(key, i));
					
				}
				
			} else {

			}
			
		}
		 
		 return list;  
		 
	 }
	 
}
