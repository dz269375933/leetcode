public class Solution10 {
    public static void main(String[] arg){
        Solution10 s=new Solution10();
        System.out.println(s.isMatch("mississippi","mis*is*ip*."));
        System.out.println(s.isMatch("aabcbcbcaccbcaabc",".*a*aa*.*b*.c*.*a*"));
//        String s=".*ssmissdd";
//        System.out.println(s.substring(1));
    }
    public Boolean isMatch(String s, String p) {
       StringBuffer sb=new StringBuffer();
       String buffer="";
       String[] array=p.split("");
       for(int i=0;i<array.length;i++){
           if(i==array.length-1){
               sb.append(array[i]);
               break;
           }
           if(array[i+1].equals("*")){
               if(array[i].equals(buffer) || buffer.equals(".")){
                   i++;
                   continue;
               }
               else{
                   sb.append(array[i]+"*");
                   buffer=array[i];
                   i++;
               }
           }else{
               buffer="";
               sb.append(array[i]);
           }
       }
       return myMatch(s,sb.toString());
    }
    public boolean pointStarMatch(String s,String p){
        String newP=p.substring(2);
        if(newP.length()==0)return true;

        for(int i=0;i<s.length();i++){
            if(myMatch(s.substring(i),newP))
                return true;
        }
        return false;
    }
    public boolean letterStarMatch(String s,String p,String letter){
        if(myMatch(s,p.substring(2)))
            return true;
        String[] sArray=s.split("");
        for( int i=0;i<sArray.length;i++){
            if(sArray[i].equals(letter)){
                if(myMatch(s.substring(i+1),p.substring(2)))
                    return true;
            }else break;
        }
        if(myMatch(s,p.substring(2)))
            return true;
        return false;
    }
    public boolean myMatch(String s,String p){
        if(s.equals(p))return true;
        String[] pArray=p.split("");
        int i;
        String buffer="";
        for(i=0;i<pArray.length-1;i++){
            if(pArray[i+1].equals("*")){
                if(pArray[i].equals(".")){
                    if(pointStarMatch(s,p.substring(i)))
                        return true;
                    else return false;
//                    String unUsedString=p.substring(i);
//                    if(unUsedString.lastIndexOf("*")!=(unUsedString.length()-1))
//                        return false;
//                    String[] tempArray=unUsedString.split("\\*");
//                    for(String temp:tempArray){
//                        if(temp.length()!=1)return false;
//                    }
//                    return true;
                }
                if(letterStarMatch(s,p.substring(i),pArray[i]))
                    return true;
                else return false;
            }else{
                if(!buffer.equals("") && pArray[i].equals(buffer))
                    continue;
                if(s.length()==0)return false;
                if(pArray[i].equals(".")){
                    s=s.substring(1);
                    continue;
                }
                if(s.indexOf(pArray[i])!=0)return false;
                else  s=s.substring(1);
            }

        }
        String lastParameter=pArray[pArray.length-1];
        if(lastParameter.equals("*")){
            if(s.length()==0)return true;
            else return false;
        }else{
            if(s.length()==0){
                if(lastParameter.equals(buffer))return true;
                if(!buffer.equals("") && lastParameter.equals("."))return true;
                return false;
            }else{
                if(s.length()==1){
                    if(lastParameter.equals(".") || lastParameter.equals(s))return true;
                    return false;
                }else{
                    return false;
                }
            }
        }
    }

}
