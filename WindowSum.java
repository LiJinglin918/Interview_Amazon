/*
windown sum. 给array或者list. 和窗口的大小。返回窗口里面的元素的和。第一个方法n, 第二个方法n^2.
*/

import java.util.*;
public class WindowSum {
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(-1);
		A.add(1);
		A.add(3);
		A.add(5);
		A.add(7);
		A.add(1);
		A.add(2);
		System.out.println(new WindowSum().getSum(A, 2));
		
		int[] array = {1,2,3,4,5};
		int[] res = new WindowSum().getSum2(array, 2);
		System.out.println("1: " + res[0] + ", 2: " + res[1]);
	}
  
    public int[] getSum(int[] array, int k) {
		if (array == null || array.length < k || k <= 0) {
			return null;
		}
		int[] res = new int[array.length - k + 1];
		for (int i = 0; i < k; i++) {
			res[0] += array[i];
		}
		// 将sum算完之后，再减去
		for (int i = 1; i < res.length; i++) {
			res[i] = res[i - 1] - array[i - 1] + array[i + k - 1];
		}
		return res;
	}
  
  /*==============================================================================================*/
  
	public List<Integer> getSum2 (List<Integer> A, int k) {
		List<Integer> res = new ArrayList<>();
		int len = A.size();
		
		// 两层循环，每次都要算sum
		for (int i = 0; i + k - 1 < len; i++) {
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += A.get(i + j);
			}
			res.add(i, sum);
		}
		return res;
	}	
}
