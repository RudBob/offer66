import java.util.ArrayList;

public class _008_minNumberInRotateArray {
    // 二分查找的变体
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return minNumberInRotateArray(nums, 0, nums.length - 1);
    }

    private int minNumberInRotateArray(int[] nums, int head, int last) {
        if (head == last - 1) {
            return nums[last] < nums[head] ? nums[last] : nums[head];
        }
        // 最终目标满足条件 nums[last] >= nums[head]
        int mid = (head + last) / 2;
        if (nums[mid] > nums[last]) {
            return minNumberInRotateArray(nums, mid, last);
        } else if (nums[mid] == nums[last] && nums[mid] == nums[head]) {
            // 恭喜你，你麻烦了.此时只能采取顺序查找
            int min = nums[head];
            for (int i = head + 1; i <= last; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            return min;
        } else {
            return minNumberInRotateArray(nums, head, mid);
        }
        // 此时处以

    }
}
