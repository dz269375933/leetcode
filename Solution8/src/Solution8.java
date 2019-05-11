import java.util.HashMap;
import java.util.Map;

public class Solution8 {
    public static void main(String[] arg){
        Solution8 s=new Solution8();
        System.out.println(s.myAtoi("  0000000000012345678"));
    }
    public int myAtoi(String str) {
        final int MIN_INT=0x80000000;
        final int MAX_INT=0x7fffffff;
        final int MAX_POSITION=10;
        Map map=new HashMap();
        map.put("0",0);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
        map.put("8",8);
        map.put("9",9);

        String[] sArray=str.split("");
        int[] valueInt=new int[MAX_POSITION+1];
        int valueIntLength=-1;
        boolean positive=true;


        for(int i=0;i<sArray.length;i++){
            if(sArray[i].equals(" ") && valueIntLength<0)continue;
            if(valueIntLength==-1){
                if(sArray[i].equals("-")){
                    positive=false;
                    valueIntLength++;
                    continue;
                }
                if(sArray[i].equals("+")){
                    valueIntLength++;
                    continue;
                }
            }
            if(map.containsKey(sArray[i])){
                if(valueIntLength<0)valueIntLength=0;
                if(valueIntLength==0 && sArray[i].equals("0"))continue;
                if(valueIntLength>MAX_POSITION){
                    if(positive)return MAX_INT;
                    else return MIN_INT;
                }
                valueInt[valueIntLength++]=Integer.valueOf(sArray[i]);

            }else {
                if(valueIntLength>0){
                    break;
                }else
                    return 0;

            }
        }
        long aim=0;
        int position=valueIntLength;
        if(positive){
            for(int i=0;i<valueIntLength;i++){
                aim+=valueInt[i]*Math.pow(10,--position);
            }
            if(aim>MAX_INT)return MAX_INT;
            else{
                Long l=new Long(aim);
                return l.intValue();
            }
        }else{
            for(int i=0;i<valueIntLength;i++){
                aim-=valueInt[i]*Math.pow(10,--position);
            }
            if(aim<MIN_INT)return MIN_INT;
            else{
                Long l=new Long(aim);
                return l.intValue();
            }
        }
    }
}
