/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

import java.util.*;
public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(2, 3));
	}
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return null;
		
		StringBuilder sb = new StringBuilder();
		if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
			sb.append("-");
		Long n = new Long (numerator);
		Long d = new Long (denominator);
		n = Math.abs(n);
		d = Math.abs(d);
		
		sb.append(n / d);
		if (n % d == 0)
			return sb.toString();
		sb.append(".");
		HashMap<Long, Integer> hm = new HashMap<>();
		Long remain = n % d;
		while (remain != 0) {
			if (hm.containsKey(remain)) {
				sb.insert(hm.get(remain), "(");
				sb.append(")");
				break;
			}
			else {
				hm.put(remain, sb.length());
				remain *= 10;
				sb.append(remain / d);
				remain %= d;
			}
		}
		return sb.toString();
	}
}
