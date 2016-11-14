// 最大公约数
public class GCD {
	public static void main(String[] args) {
		System.out.println(new GCD().gcd(18, 12));
	}
	public int gcd(int a, int b) {
		while (a != 0 && b != 0) {	   // until either one of them is 0
			int c = b;
			b = a % b;
			a = c;
		}
		return a + b;		// either one is 0, so return the non-zero value
	}
}
