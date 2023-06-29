// Problem 442. Find All Duplicates in an Array
// Given an integer array nums of length n where all the integers of nums are in the range [1, n]
// and each integer appears once or twice, return an array of all the integers that appears twice.

//First way is to use a hashset
//Another one we can sort the array.
//Now the optimised solution
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }
            else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
            
            for(int k = 0; k < arr.length; k++){
                if(arr[k] != k+1){
                    ans.add(arr[k]);
                }
        }
        return ans;        
    }
    void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
  }
}

//Another optimised solution
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0) ans.add(Math.abs(arr[i]));
            arr[index] = -1 * arr[index];
        }
        return ans;
    }
}
