package com.florent.leetcode.foursum;

import java.util.*;

/**
 * Given an array nums of n integers
 * -> return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
 * such that:
 *     0 <= a, b, c, d < n
 *     a, b, c, and d are distinct.
 *     nums[a] + nums[b] + nums[c] + nums[d] == target
 * <br/>
 * You may return the answer in any order.
 */
public class FourSumSolution {

    // 55ms (2 loops + move left and right)
    public List<List<Integer>> fourSum(final int[] nums, int target) {
        var result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int idx1 = 0; idx1 < nums.length - 3; idx1++) {
            if (idx1 > 0 && nums[idx1] == nums[idx1 - 1]) {
                continue; // deduplicate
            }

            for (int idx2 = idx1 + 1; idx2 < nums.length - 2; idx2++) {
                if( idx2 > idx1 + 1 && nums[idx2] == nums[idx2 - 1] ) {
                    continue; // deduplicate
                }
                long sum = (long) target - nums[idx1] - nums[idx2];
                int left = idx2 + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] > sum) {
                        right--;
                    }
                    else if (nums[left] + nums[right] < sum) {
                        left++;
                    }
                    else {
                        result.add(Arrays.asList(nums[idx1], nums[idx2], nums[left++], nums[right--]));
                        while ( left < right && nums[left] == nums[left - 1] ) {
                            left++;
                        }
                        while ( left < right && nums[right] == nums[right + 1] ) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }

    // 225ms (4 nested loops + sort + contains)
    public List<List<Integer>> fourSumSlow(int[] nums, int target) {
        List<List<Integer>> validLists = new ArrayList<>();

        for(int idx1 = 0; idx1 < nums.length; idx1++) {
            for(int idx2 = 0; idx2 < nums.length; idx2++) {
                for(int idx3 = 0; idx3 < nums.length; idx3++) {
                    for(int idx4 = 0; idx4 < nums.length; idx4++) {
                        // no duplicate elements
                        if (idx1 != idx2 && idx1 != idx3 && idx1 != idx4
                                && idx2 != idx3 && idx2 != idx4
                                && idx3 != idx4) {
                            int value1 = nums[idx1];
                            int value2 = nums[idx2];
                            int value3 = nums[idx3];
                            int value4 = nums[idx4];
                            if ( (long) value1 + value2 + value3 + value4 == target) {
                                var validList = new ArrayList<>(List.of(value1, value2, value3, value4));
                                Collections.sort(validList);
                                if (!validLists.contains(validList)) {
                                    validLists.add(validList);
                                }

                            }
                        }
                    }
                }
            }
        }

        return validLists;
    }


}