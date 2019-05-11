import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public static void main(String[] a){
        Solution13 s=new Solution13();
        System.out.println(s.romanToInt("MCMXCIV"));


    }
    public int romanToInt(String s) {
        int aim=0;
        Map pMap= new HashMap<String,Integer>();
        Map map=new HashMap();
        Map pKeyMap=new HashMap();
        pMap.put("IV",4);
        pMap.put("IX",9);
        pMap.put("XL",40);
        pMap.put("XC",90);
        pMap.put("CD",400);
        pMap.put("CM",900);

        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        pKeyMap.put("I",0);
        pKeyMap.put("X",0);
        pKeyMap.put("C",0);


        String[] cArray=s.split("");
        for(int i=0;i<cArray.length;){
            if(pKeyMap.containsKey(cArray[i])){
                if(i!=cArray.length-1 )
                {
                    if(pMap.containsKey(cArray[i]+cArray[i+1])){
                        aim=aim+(Integer)pMap.get(cArray[i]+cArray[i+1]);
                        i+=2;
                        continue;
                    }

                }
            }
            aim+=(Integer)map.get(cArray[i]);
            i++;
        }

        return aim;
    }
}
