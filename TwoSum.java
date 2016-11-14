public int[] twoSum2(int[] numbers, int target) {
		int[] res = new int[2];
		Map <Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (hm.containsKey(target - numbers[i])) {
				res[0] = hm.get(target - numbers[i]);
				res[1] = i;
				return res;
			}
			hm.put(numbers[i],i);
		}
		throw new IllegalArgumentException("No such two numbers by the twoSum2");
	}



//*---------------------------------------------------------------------------------------------------*//
// Two sum 2
import java.util.ArrayList;
import java.util.HashMap;

public class twosum {
	private void twosums(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				for(int j : map.get(target - nums[i])){
					System.out.println(i + " " + j);
				} 
			}
			if(!map.containsKey(nums[i])){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(nums[i], temp);
			}
			else{
				map.get(nums[i]).add(i);
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,2,3,3,4,6,2,7,8,5,4,6,3,2};
		twosums(nums, 5);
	}
}
