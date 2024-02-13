
public class pass_key_count {
	int key2;
	int count_sold;
	int key3;
	int count_sold1;
	int count_add;
	pass_key_count(){
		
		
	}
	public  void passKey(String key1) {
    	key2 = Integer.parseInt(key1);
    	
    	}
	public void passCountSold(int count) {
		count_sold = count;
		
	}
	public void passCountAdd(int count) {
		count_add = count;
		
	}
	
	public  void store(int key2, int count_sold) {
		key3 = key2;
		count_sold1 = count_sold;
		
	}
}
