/*
/Write a function that will take in email lists and return a new email list that contains only the email addresses that existed in all lists-google 1point3acres
// 1: foo@amazon.com, bar@amazon.com
// 2: bar@amazon.com, bar@amazon.com.
// o: bar@amazon.com
*/

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class SameElements {
	private static List<String> find(ArrayList<ArrayList<String>> list){
		ArrayList<String> res = new ArrayList<String>();
		if(list == null || list.size() == 0)return res;
		Set<String> set = new HashSet<String>();
		for(String s : list.get(0)) set.add(s);
		for(int i = 1; i < list.size(); i++){
			Set<String> temp = new HashSet<String>();
			for(String s : list.get(i)){
				if(set.contains(s)){
					temp.add(s);
				}
			}
			set = temp;
		}
		for(String s : set){
			res.add(s);
		}
		return res;
	}
	
	
	
	public static void main(String[] args){
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		list1.add("aa");
		list1.add("ba");
		list1.add("ca");
		list1.add("ta");
		list2.add("aa");
		list2.add("ca");
		list3.add("aa");
		list3.add("ta");
		list3.add("ca");
		list.add(list1);
		list.add(list2);
		list.add(list3);
		for(String s : find(list)){
			System.out.println(s);
		}
	}
}
