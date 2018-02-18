package LeetCode_idea.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2) return false;
        if(k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        long bucketSize = (long) t + 1;

        for(int i = 0; i < nums.length; ++i){
            long bucket = getID(nums[i], bucketSize);
            if(map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && Math.abs(nums[i] - map.get(bucket - 1)) <= t)
                    || (map.containsKey(bucket + 1) && Math.abs(nums[i] - map.get(bucket + 1)) <= t))
                return true;
            if(i >= k){
                map.remove(getID(nums[i - k], bucketSize));
            }
            map.put(bucket, (long) nums[i]);
        }
        return false;
    }

    private static long getID(long i, long w){
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
    /*
    * w = 3
    i  i/w* desired**
    -5 -1   -2
    -4 -1   -2
    -3 -1   -1
    -2  0   -1
    -1  0   -1
     0  0    0
     1  0    0
     2  0    0
     3  1    1
     4  1    1
     5  1    1
     *
     *
     *  */

    public static boolean containsNearbyAlmostDuplicate_2(int[] nums, int k, int t){
        if(nums == null || nums.length < 2) return false;
        if(k < 1 || t < 0) return false;
        TreeSet<Long> tree = new TreeSet<>();
        for(int i = 0; i < nums.length; ++i){
            Long ceiling = tree.ceiling((long) nums[i] - t);
            if(ceiling != null && ceiling - nums[i] <= t) return true;
            if(i >= k)
                tree.remove((long) nums[i - k]);
            tree.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,2,6};
        System.out.println(containsNearbyAlmostDuplicate(nums1, 2, 0));
        System.out.println(containsNearbyAlmostDuplicate_2(nums1, 2, 0));
        System.out.println(containsNearbyAlmostDuplicate(nums1, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate_2(nums1, 3, 0));
        int[] nums2 = {10,2,19,90,3,36};
        System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums2, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate(nums2, 3, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums2, 3, 1));

        int[] nums3 = {4,2};
        System.out.println(containsNearbyAlmostDuplicate(nums3, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums3, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate(nums3, 3, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums3, 3, 1));


        int[] nums4 = {2147483647, 2147483646};
        System.out.println(containsNearbyAlmostDuplicate(nums4, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums4, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate(nums4, 3, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums4, 3, 1));

        int[] nums5 = {-2147483647, 2147483646};
        System.out.println(containsNearbyAlmostDuplicate(nums5, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums5, 2, 1));
        System.out.println(containsNearbyAlmostDuplicate(nums5, 3, 1));
        System.out.println(containsNearbyAlmostDuplicate_2(nums5, 3, 1));



    }
}
