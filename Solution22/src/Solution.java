import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        List sss=s.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> answer=new ArrayList<>();
        myGenerate(answer,"",0,0,n);
        return answer;
    }
    public void myGenerate(List<String> answer,String current,int open,int close,int max){
        if((open+close)==max*2){
            answer.add(current);
            return;
        }
        if(open<max){
            myGenerate(answer,current+"(",open+1,close,max);
        }
        if(close<open){
            myGenerate(answer,current+")",open,close+1,max);
        }
    }
}
