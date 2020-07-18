package dan.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSumSolution1(int[] nums, int target) {
        int[][] arryWithPos = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arryWithPos[i][0] = nums[i];
            arryWithPos[i][1] = i;
        }
        Arrays.sort(arryWithPos,  (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        // i ->  ...................  <- j
        int[] ret = new int[2];
        int i = 0, j = nums.length-1;
        while (i < j) {
            int tmp = arryWithPos[i][0] + arryWithPos[j][0];
            if (tmp == target) {
                ret[0] = arryWithPos[i][1];
                ret[1] = arryWithPos[j][1];
                Arrays.sort(ret);
                break;
            } else if (tmp < target) {
                i++;
            } else if (tmp > target) {
                j--;
            }
        }

        return ret;
    }

    public int[] twoSumSolution2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;

                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] input = {3, 32, 11, 21, 19, 12, 27}; // input array
        int target = 31; // input value for the target sum
        int[] result = new TwoSum().twoSumSolution2(input, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
