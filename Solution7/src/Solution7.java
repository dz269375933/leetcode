public class Solution7 {
    public static void main(String[] arg){
        Solution7 s=new Solution7();
        System.out.println(s.reverse(120));
    }
    public int reverse(int x) {
//        final Integer MAX_INT=2147483647;
//        final Integer MIX_INT=-2147483648;
        boolean flag;
        if(x>0)flag=true;
        else{
            x=-x;
            flag=false;
        }
        String xString=String.valueOf(x);
        String[] sArray=xString.split("");
        StringBuffer sb=new StringBuffer();
        for(int i=sArray.length-1;i>=0;i--){
            sb.append(sArray[i]);
        }
        int aim=0;
        try {
            aim=Integer.valueOf(sb.toString());
            if(!flag)aim=-aim;
        }catch (NumberFormatException e){
            aim=0;
        }finally {
            return aim;
        }
    }

}
