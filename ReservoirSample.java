/*
Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items, where n is either a very large or unknown number. Typically n is large enough that the list doesn’t fit into main memory. 
*/
/*
It can be solved in O(n) time. The solution also suits well for input in the form of stream. The idea is similar to this post. Following are the steps.

1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
2) Now one by one consider all items from (k+1)th item to nth item.
…a) Generate a random number from 0 to i where i is index of current item in stream[]. Let the generated random number is j.
…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
*/

public void select(int stream[], int n, int k){
    int i;
    int[] reservoir = new int[k];
    for(i = 0; i < k; i++){
        reservoir[i] = stream[i];
    }
    for(; i < n; i++){
		// random() 返回0-1的double随机数
        int j = random.nextInt(i + 1);
        if(j < k) reservoir[j] = stream[i];
    }
}

/*===================================================================*/

    /*
     * random sample
     */
    public static int[] randomSample(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m <= 0) return new int[]{};

        int[] sample = new int[m];
        for (int i = 0; i < m; i++) {
            sample[i] = nums[i];
        }

        Random random = new Random();
		
		// nums.length 即为n 
        for (int i = m; i < nums.length; i++) {
            int k = random.nextInt(i + 1); // 0~i(inclusive)
            if (k < m) {
                sample[k] = nums[i];
            }
        }

        return sample;
    }
