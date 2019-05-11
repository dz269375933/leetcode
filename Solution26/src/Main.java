public class Main {
    public static void main(String[] arg){
        int[] nums={0,0,1,1,2,2,3,4};
        int current=nums[0];
        int counter=1;
        int last=nums.length;
        for(int i=1;i<last;i++){
            if(current==nums[i]){
                forward(nums,i);
                last--;
                i--;
            }else{
                counter++;
                current=nums[i];
            }
        }
        System.out.println(counter);
    }
    public static void forward(int[] nums,int index){
        for(int i=index;i<nums.length-1;i++){
            nums[i]=nums[i+1];
        }
    }
}
