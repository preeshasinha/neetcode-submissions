class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> index= new HashMap<>();

        for(int i=0; i<nums.length;i++){
            int num = nums[i];
            int diff=target-num;

            if(index.containsKey(diff)){
                return new int[]{index.get(diff),i};
            }

            index.put(num,i);
        }

        return new int[] {};
        
    }
}