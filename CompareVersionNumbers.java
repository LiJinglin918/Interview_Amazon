/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
Here is an example of version numbers ordering:
0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = Math.max (v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            Integer a = i < v1.length? Integer.parseInt (v1[i]) : 0;
            Integer b = i < v2.length? Integer.parseInt (v2[i]) : 0;
            int compare = a.compareTo(b);
            if (compare != 0)
                return compare;
        }
        return 0;
    }
}
