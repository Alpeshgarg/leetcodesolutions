class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> lol = new ArrayList<>();
         Arrays.sort(nums);
         int count=0,max=1;
         lol.add(new ArrayList<>());
         lol.get(0).add(nums[0]);
         for(int i=1;i<nums.length;i++)
         {
             if(nums[i]==nums[i-1]){
             count++; 
             if(count<max)
             {
                 lol.get(count).add(nums[i]);

             }
             else
             {
                  lol.add(new ArrayList<>());
                  max++;
                 lol.get(count).add(nums[i]);

             }
             }
             else
             {
                 count=0;
                 lol.get(count).add(nums[i]);
             }
         }
         return lol;
    }}
    