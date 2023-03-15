class Solution {
    public String solution(int n) {
        StringBuilder str = new StringBuilder();
        switch(n){
            case 1 : return "1";
            case 2:  return "2";
            case 3:  return "4";   
                }
        
        while(true){

            if(n%3==0){
                str.append("4");
            }else if(n%3==1){
                str.append("1");
            }else if(n%3 == 2){
                str.append("2");
            }
            
            n = (n-1)/3;
            
            
            if(n <1){
                break;
            }
            
        }
        
        return str.reverse().toString();
    }
}

