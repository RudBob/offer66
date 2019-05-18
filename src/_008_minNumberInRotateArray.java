import java.util.ArrayList;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如
 * <p>
 * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。
 * <p>
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class _008_minNumberInRotateArray {
    // 二分查找的变体
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return minNumberInRotateArray(nums, 0, nums.length - 1);
    }

    /**
     * 重点是特殊情况 [1,1,1,0,1],这种情况下，就只能遍历了
     */
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
    }
}
