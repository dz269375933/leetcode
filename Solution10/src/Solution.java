public class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        s.isMatch("aa","a*aabb");
    }
    public Boolean isMatch(String s, String p) {
        int length=0;
        String[] pamameter=new String[100];
        String[] pArray=p.split("");
        String[] aimArray=s.split("");
        boolean[] parameterBoolean=new boolean[100];
        boolean[] unused=new boolean[100];
        for(String string:pArray){
            if(string.equals("*")){
                parameterBoolean[length-1]=true;
            }else{
                pamameter[length++]=string;
            }
        }

        for(int i=0;i<aimArray.length;i++){

        }
        return true;
    }
}
