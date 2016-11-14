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
