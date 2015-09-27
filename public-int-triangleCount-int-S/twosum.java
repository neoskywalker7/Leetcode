public int[] twoSum(int[] numbers, int target) {// first sort, second two 
	if(numbers == null || numbers.length < 2) {
            return null;
        }
        
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            hash.put(numbers[i],i+1);
        }
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        int[] rst = new int[2];

        while( left < right){
            int sum = numbers[left] +  numbers[right];
            if( sum == target){
                rst[0] = hash.get(numbers[left]);
                rst[1] = hash.get(numbers[right]);
                break;
            }else if( sum < target){
                left++;
            }else{
                right--;
            }
        }
        Arrays.sort(rst);
        return rst;
    }
}
