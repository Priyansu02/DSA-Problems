class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        //ArrayList<Integer>al=new ArrayList<>();
         List<List<Integer>> ans= new ArrayList<>();
         Arrays.sort(nums);
         helper(ans,new ArrayList<>(),nums,0);
         return ans;
    }
    public void helper(List<List<Integer>>ans, List<Integer>al,int nums[],int idx){
        ans.add(new ArrayList<>(al));

        for(int i=idx; i<nums.length;i++){
            al.add(nums[i]);
            helper(ans,al,nums,i+1);
            al.remove(al.size()-1);
        }
    }
}