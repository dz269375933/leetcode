import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] arg){
        Solution15 s=new Solution15();
        List<List<Integer>> a=s.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(a.get(0).get(0));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List result=new ArrayList();
        if(nums.length<3)return result;
        Arrays.sort(nums);
        if(nums[0]==0 && nums[nums.length-1]==0){
            List temp=new ArrayList();
            temp.add(0);
            temp.add(0);
            temp.add(0);
            result.add(temp);
            return result;
        }
        if(nums[0]>=0 || nums[nums.length-1]<=0)return result;
        int firstZero=0;
        int numberOfZero=0;

        boolean flag=false;
        for(firstZero=0;firstZero<nums.length;firstZero++){
            if(nums[firstZero]==0){
                flag=true;
                break;
            }
            if(nums[firstZero]>0)break;
        }
        //if if have zero

        if(flag){
            for(int j=firstZero+1;j<nums.length;j++){
                if(nums[j]!=0)break;
                numberOfZero++;
            }
            int negativeIndex=0,positiveIndex=nums.length-1;
            int negativeBuffer=1;
            while(negativeIndex<firstZero && positiveIndex>firstZero+numberOfZero){
                if(nums[negativeIndex]==negativeBuffer)continue;
                int current=-nums[negativeIndex];
                if(current<nums[positiveIndex]){
                    positiveIndex--;
                }else if(current>nums[positiveIndex]){
                    negativeIndex++;
                }else{

                    negativeBuffer=nums[negativeIndex];
                    List temp=new ArrayList();
                    temp.add(nums[negativeIndex++]);
                    temp.add(0);
                    temp.add(nums[positiveIndex--]);
                    result.add(temp);
                }
            }
        }
        int iBuffer=-100000;
        int kBuffer=-10000;
        for(int i=0;i<firstZero;i++){
            if(iBuffer==nums[i])continue;
            iBuffer=nums[i];
            for(int k=nums.length-1;k>=firstZero+numberOfZero;k--){
                if(kBuffer==nums[k])continue;
                kBuffer=nums[k];
                int t=nums[i]+nums[k];
                for(int j=i+1;j<k;j++){
                    int sum=nums[i]+nums[k]+nums[j];
                    if(sum==0){
                        List temp=new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if(!result.contains(temp)){
                            result.add(temp);
                        }
                    }
                    if(t*sum<0)break;
                    if(j==firstZero)j=j+numberOfZero;

                }
            }
        }
        return result;
    }
}
