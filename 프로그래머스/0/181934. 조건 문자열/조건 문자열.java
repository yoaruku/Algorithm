class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        
        boolean bEq = false;
        boolean bIneq = false;
        
        if (ineq.equals("<")){
            bIneq = n < m ? true : false;
        }
        
        if (ineq.equals(">")){
            bIneq = n > m ? true : false;
        }
        
        if (eq.equals("=")){
            bEq = n == m ? true : false;
        }
        
        int result = 0;
        if(bIneq){
            
            if(eq.equals("!") && bEq){
                result = 0;
            }else{
                result = 1;
            }
        }
        
        if(!bIneq){
            
            if(eq.equals("=") && bEq){
                result = 1;
            }
        }
        
        return result;
    }
}