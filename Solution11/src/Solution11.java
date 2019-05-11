public class Solution11 {
    public static void main(String[] arg){
        Solution11 s=new Solution11();
        int[] a={1,8,6,2,5,4,8,3,7};
        s.maxArea(a);
    }
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while (left<right){
            int value=(right-left)*Math.min(height[left],height[right]);
            max=Math.max(max,value);
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}
