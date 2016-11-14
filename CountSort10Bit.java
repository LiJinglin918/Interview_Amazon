        
		// 给500000个10bit的数，排序
		/*
		1. new 一个数组用来计数（重复的也算）
		2. 另一个for loop用来算这个元素的position。
		3. new 一个temp数组，从小到大遍历这个countArray
		4. 最后将temp拷贝进原数组
		*/
		
		
		public static void countSort(int[] array, int range) throws Exception {  
            if (array.length <= 1) {  
                return;  
            }  
			
			// 创建新数组，用来计数
            int[] countArray = new int[range + 1];  
            for (int i = 0; i < array.length; i++) {  
                int value = array[i];  
                if (value < 0 || value > range) {  
                    throw new Exception("array element overflow range.");  
                }  
                countArray[value]++;  
            }  
			
			// 用此数组来记录position
            for (int i = 1; i < countArray.length; i++) {  
                countArray[i] += countArray[i - 1];  
            }  
  
            int[] temp = new int[array.length];  
            for (int i = array.length - 1; i >= 0; i--) {  
                int value = array[i];  
                int position = countArray[value] - 1;  
  
                temp[position] = value;  
                countArray[value] -= 1;  
            }  
  
            for (int i = 0; i < array.length; i++) {  
                array[i] = temp[i];  
            }  
        }  
