class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        //ArrayList<Integer>al=new ArrayList<>();
         List<List<Integer>> ans= new ArrayList<>();
         
         helper(ans,new ArrayList<>(),nums,0);
         return ans;
    }
    public void helper(List<List<Integer>>ans, List<Integer>al,int nums[],int idx){
        if(idx == nums.length){
            ans.add(new ArrayList<>(al));
            return;
        }
       

        //exclude
        helper(ans, al, nums,idx+1);

        //include
        al.add(nums[idx]);
        helper(ans, al, nums,idx+1);
        al.remove(al.size()-1);
    }
}