public class Solution6 {
    public static void main(String[] arg){
        Solution6 s=new Solution6();
        System.out.println(s.convert("LEETCODEISHIRING",4));
    }
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuffer sb=new StringBuffer("");
        String[] sArray=s.split("");
        int length=sArray.length;

        for(int i=1;i<=numRows;i++){
            int top=topNum(i);
            int down=downNum(numRows,i);
            if(top==0){
                for(int j=i-1;j<length;){
                    sb.append(sArray[j]);
                    j+=down+1;
                }
            }else if(down==0){
                for(int j=i-1;j<length;){
                    sb.append(sArray[j]);
                    j+=top+1;
                }
            }else{
                boolean b=true;
                for(int j=i-1;j<length;){
                    sb.append(sArray[j]);
                    j+= b?down+1:top+1;
                    b=!b;
                }
            }

        }
        return sb.toString();
    }
    public int downNum(int allNumRows,int correntNum){
        if(correntNum==allNumRows)return 0;
        return allNumRows+allNumRows-correntNum-correntNum-1;
    }
    public int topNum(int correntNum){
        if(correntNum==1)return 0;
        return correntNum+correntNum-3;
    }
}
