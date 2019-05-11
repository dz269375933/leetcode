import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] arg){
//        Main m=new Main();
//        int aim=m.lengthOfLongestSubstring(" ");
//        System.out.println(aim);
        Map m=new HashMap();
        m.put("1","1");
        m.put("1","1");
    }
    public int lengthOfLongestSubstring(String s) {
        char[] cArray=s.toCharArray();
        int start=0;
        int length=0;
        int aim=0;
        Map map=new HashMap();
        for(int i=0;i<cArray.length;i++){
            if(map.containsKey(cArray[i])){

                int firstRepetition=(int)map.get(cArray[i]);
                for(int k=start;k<firstRepetition;k++){
                    map.remove(cArray[k]);
                }
                start=firstRepetition+1;
                length=i-start+1;
                map.put(cArray[i],i);
            }else{
                length++;
                map.put(cArray[i],i);
            }
            if(aim<length)aim=length;
        }
        return aim;
    }
}
