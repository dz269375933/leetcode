import java.util.HashMap;
import java.util.Map;

public class Main {
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int first=nums[i];
            if(map.containsKey(target-first)){
                return new int[]{i,(Integer) map.get(target-first)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
