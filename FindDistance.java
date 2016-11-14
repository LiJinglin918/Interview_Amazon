
/* This class will be given a list of words (such as tokenized words from a paragraph of text).
* It will also provide a method that takes two words and returns the shortest distance(in words)
* between these two words in the provided text.
* Example:
* WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList(“the”, “quick”, “brown”, “fox”, “quick”));
* assert(finder.distance(“fox”, “the”) == 3);
* assert(finder.distance(“quick”, “fox”) == 1);
*/
// 找最短的距离（array里面允许重复）

public class findDistance {

	public static int Distance(String[] words, String word1, String word2) {
	
	        if(words == null || words.length <= 0) return -1;
	        int n = words.length;
	        int index1 = -1;
	        int index2 = -1;
	        int res = n;
	        for(int i = 0; i < words.length; ++i) {
	
	            if(words[i] == word1) index1 = i;
	            if(words[i] == word2) index2 = i;
	            if((words[i] == word1 || words[i] == word2) && index1 != -1 && index2 != -1) {
	            	res = Math.min(Math.abs(index1 - index2), res);
	            }
	        }
	        return res;
	    }

	public static void main(String[] args){
		String[] s = {"the", "quick", "brown", "fox", "quick"};
		System.out.println(Distance(s, "the", "fox"));
	}
}
