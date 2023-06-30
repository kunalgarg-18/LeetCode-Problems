// 229. Majority Element II
class Solution {    
    public List<Integer> majorityElement(int[] nums){
        
        // This method is good but uses O(n) space. Can we solve it without space?
                
        List<Integer> ans = new ArrayList<>();
        
        if(nums.length == 1){
            
            ans.add(nums[0]);
            return ans;
        }
        
        Map<Integer, Integer> map = new HashMap<>();//uses hashmap
        
        for(int e : nums){
            
            if(map.containsKey(e)) map.replace(e, map.get(e) + 1);
            else map.put(e, 1);
        }
        
        for(Integer i : map.keySet()){
            
            if(map.get(i) > nums.length/3) ans.add(i);
        }
        return ans;
    
    // We need to optimize this further
        
        List<Integer> ans = new ArrayList<>();
        
        if(nums.length == 0) return ans;
        int firstMajor = Integer.MAX_VALUE, firstSum = 0, secondMajor = Integer.MIN_VALUE, secondSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == firstMajor) firstSum++;
            else if(nums[i] == secondMajor) secondSum++;
            else if(firstSum == 0){
                firstMajor = nums[i];
                firstSum++;
            } 
            else if(secondSum == 0){
                secondMajor = nums[i];
                secondSum++;
            } 
            else{
                firstSum--;
                secondSum--;
            }
        }

        int countOne = 0, countTwo = 0;
        for(int ele : nums){
            if(ele == firstMajor) countOne++;
            else if(ele == secondMajor) countTwo++;
        }

        if(countOne > nums.length/3) ans.add(firstMajor);
        if(countTwo > nums.length/3) ans.add(secondMajor);

        return ans;        
    }
}
