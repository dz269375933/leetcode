import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        if (s.equals(""))return true;
        Map map =new HashMap();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");

        String[] stringArray=s.split("");
        List<String> list=new ArrayList<>();
        for(String string:stringArray){
            if(list.size()==0){
                list.add(string);
            }else{
                String key=list.get(list.size()-1);
                if (key!="(" && key!="{" && key!="[")return false;
                if(map.get(key).equals(string)){
                    list.remove(list.size()-1);
                    continue;
                }else {
                    list.add(string);
                }
            }
        }
        if(list.size()!=0)return false;
        else return true;
    }
}
