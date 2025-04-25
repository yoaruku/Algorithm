class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[2];
        
        for(int num : num_list){
            result[num%2]++;
        }
        
        return result;
    }
}