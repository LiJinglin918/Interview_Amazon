import java.util.LinkedList;
import java.util.List;

public class CacheMiss {
    public int Solution(int[] array, int size) {
        if (array == null)  return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (cache.contains(array[i])) {
                cache.remove(new Integer(array[i]));
            }
            else {
                count++;
                if (size == cache.size())
                    cache.remove(0);
            }
            cache.add(array[i]);
        }
        return count;
    }
}
