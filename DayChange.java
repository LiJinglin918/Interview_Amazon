/*
 * 一个cell，如果左右两边的数一样，则将这个数设置为0，否则设置为1，
 * 题中用inactive和active来描述，后来给出的coding中用0和1表示。
 * 因为第一个数和最后一个数都只有一个相邻的数，因此设置为0。给出天数days，求days之后的结果。
 */
 
import java.util.*;
public class DayChange {
	public static void main(String[] args) {
		int[] days = {1,0,0,0,0,1,0,0};
		int[] res = new DayChange().Solution(days, 1);
		System.out.println(res[1]);
	}
	
	public int[] Solution(int[] days, int n) {
		if (days == null || n <= 0)
			return days;
		int len = days.length;
		
		// 建立新数组，将第一个和最后一个设为0
		int[] rvalue = new int[len + 2];
		rvalue[0] = rvalue[len + 1] = 0;
		
		// 将int[] days 拷贝到新数组。
		for (int i = 1; i <= len; i++) {
			rvalue[i] = days[i - 1];
		}
		
		// 用pre存储之前的元素
		int pre = 0;
		for (int i = 0; i < n; i++) {
			// 用pre记录i之前的数，实际上就是新数组里面的数。
			pre = rvalue[0];
			
			// 左右数一样设为0， 否则1
			for (int j = 1; j <= len; j++) {
				int temp = rvalue[j];
				rvalue[j] = pre ^ rvalue[j + 1];
				pre = temp;
			}
		}
		// 返回新array排除掉第一和最后一个元素
		return Arrays.copyOfRange(rvalue, 1, len + 1);
	}
}
