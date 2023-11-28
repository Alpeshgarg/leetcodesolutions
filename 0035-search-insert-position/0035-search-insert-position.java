class Solution {
   public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // Adjust low pointer
            } else {
                high = mid - 1; // Adjust high pointer
            }
        }
        return low; // Return the index for insertion position
    }
}