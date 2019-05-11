import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        List<String> array=s.letterCombinations("23");
        for(String string:array){
            System.out.println(string);
        }

    }
    public List<String> letterCombinations(String digits) {

        String [][] phone={
                {},
                {},
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"},
                {"j","k","l"},
                {"m","n","o"},
                {"p","q","r","s"},
                {"t","u","v"},
                {"w","x","y","z"}
        };
        List<String> list=new ArrayList<String>();
        if(digits.equals(""))return list;
        String[] digitsArray=digits.split("");
        List<Integer> valueList=new ArrayList<>();
        for(String s:digitsArray){
            char c=s.charAt(0);
            if(c<'2'|| c>'9')continue;
            else valueList.add(c-'0');
        }
        String[] listArray=combine(valueList,phone);
        for(String s:listArray){
            list.add(s);
        }
        return list;
    }
    public String[] combine(List<Integer> list,String[][] phone){
        if(list.size()==0)return null;
        int number=list.get(0);
        list.remove(0);
        String[] currentString=phone[number];
        String[] lastString=combine(list,phone);
        if(lastString==null)return currentString;
        else{
            List<String> tempList=new ArrayList<>();
            for(String s:currentString){
                for(String newString:lastString){
                    tempList.add(s+newString);
                }
            }
            String[] string=new String[tempList.size()];
            tempList.toArray(string);
            return string;
        }
    }
}
