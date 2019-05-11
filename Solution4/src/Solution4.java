public class Solution4 {
    public static void main(String[] arg){
        Solution4 s= new Solution4();
        System.out.println(s.findMedianSortedArrays(new int[]{1,3,4},new int[]{0}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthA=nums1.length;
        int lengthB=nums2.length;
        int lengthSum=lengthA+lengthB;
        int[] nums = new int[lengthSum];
        int index=0;
        for(int i=0,j=0;;){
            if(i==lengthA){
                for(int k=j;k<lengthB;k++){
                    nums[index++]=nums2[k];
                }
                break;
            }
            if(j==lengthB){
                for(int k=i;k<lengthA;k++){
                    nums[index++]=nums1[k];
                }
                break;
            }
            if(nums1[i]<nums2[j]){
                nums[index++]=nums1[i++];
            }else{
                nums[index++]=nums2[j++];
            }
        }
        if((lengthSum%2)==1){
            return nums[lengthSum/2];
        }else{
            return (nums[lengthSum/2]+nums[lengthSum/2-1])*1.0/2;
        }
    }
}
