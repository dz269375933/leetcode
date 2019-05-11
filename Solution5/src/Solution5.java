public class Solution5 {
    public static void main(String[] arg){
        Solution5 s=new Solution5();
        System.out.println(s.longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        char[] charArray=s.toCharArray();
        int middle=0;
        int maxLength=0;
        int allLength=charArray.length;
        if (allLength<=1)return s;
        for(int i=0;i<allLength-1;i++){
            if((maxLength/2+i)>allLength)break;
            int tempLength=1;
            int left=i;
            int right=i;
            while(--left>=0 && ++right<allLength){
                if(charArray[left]!=charArray[right])break;
                tempLength+=2;
            }
            if(tempLength>maxLength){
                maxLength=tempLength;
                middle=i;
            }

            if(charArray[i]==charArray[i+1]){
                tempLength=2;
                int tleft=i;
                int tright=i+1;
                while(--tleft>=0 && ++tright<allLength){
                    if(charArray[tleft]!=charArray[tright])break;
                    tempLength+=2;
                }
                if(tempLength>maxLength){
                    maxLength=tempLength;
                    middle=i;
                }
            }
        }
        int startIndex=middle-maxLength/2+1-maxLength%2;
        int endIndex_1=startIndex+maxLength;
        return s.substring(startIndex,endIndex_1);
    }
}
