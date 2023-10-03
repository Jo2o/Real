package leetcode.sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i = 0; i <= (nums.length - 3); i++) {
            for(int j = 1; j <= (nums.length - 2); j++) {
                for(int k = 2; k <= (nums.length - 1); k++) {
                    if ((i!=j && j!=k && i!=k) && (nums[i] + nums[j] + nums[k] == 0)) {
                        List<Integer> res = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(res);
                        result.add(res);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

}
