import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] arg){
        Solution s=new Solution();
        s.fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list =new ArrayList<>();
        if(nums.length<4)return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int left=j+1;
                int right=nums.length-1;
                while (left<right){
                    if((nums[i]+nums[j]+nums[left]+nums[right])<target)left++;
                    else if((nums[i]+nums[j]+nums[left]+nums[right])>target)right--;
                    else{
                        List<Integer> tempList=new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        if(!list.contains(tempList))list.add(tempList);
                        left++;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
