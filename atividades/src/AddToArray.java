import java.util.ArrayList;

public class AddToArray <T>{

	private static int[][] lista = new int[1][1];
	
	
	public AddToArray() {
		
	}
	
	public void add(ArrayList<Integer> nums) {
		
		int index = 0;
		
		if (lista.length == 1) {
			index = 1;
		} else {
			
			index = lista.length + 1;
			
		}
		
		int[] toAdd = new int[nums.size()];
		
		for (int i = 0; i < nums.size(); i++) {
			
			toAdd[i] = nums.get(i);
			
		}
		
		
		
		lista = new int[index][1];
		
		lista[0] = new int[2];
		
		
	}
	
}
