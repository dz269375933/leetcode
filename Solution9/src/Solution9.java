public class Solution9 {
    public boolean isPalindrome(int x) {
        String xString=String.valueOf(x);
        String[] xArray=xString.split("");
        int length=xArray.length;
        for(int i=0;i<length;i++){
            if(!xArray[i].equals(xArray[length-1-i]))
                return false;
        }
        return true;
    }
}
