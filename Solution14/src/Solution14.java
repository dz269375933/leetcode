import java.util.Arrays;

public class Solution14 {
    public static void main(String[] arg){
//        Solution14 s=new Solution14();
//        String[] strs={"flower","flow","flight"
//        };
//        System.out.println(s.longestCommonPrefix(strs));
        int[] nums={-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        System.out.println("2");
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10000;i++){
            if(i==strs[0].length())break;
            String temp=strs[0].substring(i,i+1);
            for(String string:strs){
                if(i==string.length())return sb.toString();
                if(!string.substring(i,i+1).equals(temp))return sb.toString();
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
