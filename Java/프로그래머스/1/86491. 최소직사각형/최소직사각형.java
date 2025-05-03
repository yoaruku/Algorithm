class Solution {
    public int solution(int[][] sizes) {
        
        int maxX = 0;
        int maxY = 0;
        
        for(int[] size : sizes){
            maxX = Math.max(maxX, Math.max(size[0], size[1]));
            maxY = Math.max(maxY, Math.min(size[0], size[1]));
        }
        
        return maxX * maxY;
    }
}