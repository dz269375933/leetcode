import java.util.Arrays;

public class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        System.out.println(s.threeSumClosest(new int[]{1,-1,2,-4},1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int error=1000000;
        boolean positive=true;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    boolean tempBool=true;
                    int tempError=target-(nums[i]+nums[j]+nums[k]);
                    if(tempError<0){
                        tempBool=false;
                        tempError=0-tempError;
                    }
                    if(tempError==0)return target;
                    if(tempError<error){
                        error=tempError;
                        positive=tempBool;
                    }else continue;
                }
            }
        }
        if(positive)return target-error;
        else return target+error;
    }
}
