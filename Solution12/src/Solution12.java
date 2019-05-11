import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution12 {
    public static void main(String[] arg){
        Solution12 s=new Solution12();
        System.out.println(s.intToRoman(1994));

    }
    public String intToRoman(int num) {
        List<Pair> list=new ArrayList<Pair>();
        list.add(new Pair<Integer,String>(1000,"M"));
        list.add(new Pair<Integer,String>(900,"CM"));
        list.add(new Pair<Integer,String>(500,"D"));
        list.add(new Pair<Integer,String>(400,"CD"));
        list.add(new Pair<Integer,String>(100,"C"));
        list.add(new Pair<Integer,String>(90,"XC"));
        list.add(new Pair<Integer,String>(50,"L"));
        list.add(new Pair<Integer,String>(40,"XL"));
        list.add(new Pair<Integer,String>(10,"X"));
        list.add(new Pair<Integer,String>(9,"IX"));
        list.add(new Pair<Integer,String>(5,"V"));
        list.add(new Pair<Integer,String>(4,"IV"));
        list.add(new Pair<Integer,String>(1,"I"));

        StringBuffer aim=new StringBuffer("");
        for(Pair<Integer,String> p:list){
            int temp=p.getKey();
            if(num>=temp){
                for(int i=0;i<num/temp;i++){
                    aim.append(p.getValue());
                }
                num=num-num/temp*temp;
            }
        }
        return aim.toString();
    }
}
