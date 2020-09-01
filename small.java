import java.util.*;

public class small {
    public static void main(String[] args) {
        int nums[]=new int[]{2,3,1,1,4};
            if(nums.length == 1) {
                System.out.print(0);
                System.exit(0);
            }
            if(nums[0] == 0)
            {
                System.out.print(0);
                System.exit(0);
            }
            int maxReach = nums[0];
            int steps = nums[0];
            int jumps = 0;
            for(int i = 1; i < nums.length - 1; i++) {
                maxReach = Math.max(maxReach, nums[i] + i);
                if(nums[i] == 0 && maxReach == i)
                {
                    System.out.print(0);
                    System.exit(0);
                }
                steps--;
                if(steps == 0) {
                    jumps++;
                    steps = maxReach - i;
                }
            }
            System.out.println(jumps + 1);



    }
}
