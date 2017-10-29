public class DuplicateNumberRangeFinder {
    public static void main(String[] args) {
        int[] nums = {0, 0, 2, 3, 3, 3, 3, 4, 7, 7, 9};
        int toFind = 3;

        int startIndex = -1;
        int endIndex = -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == toFind && (mid == 0 || nums[mid - 1] < toFind)) {
                startIndex = mid;
                break;
            } else if (nums[mid] < toFind) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == toFind && (mid == n - 1 || nums[mid + 1] > toFind)) {
                endIndex = mid;
                break;
            } else if (nums[mid] <= toFind) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Start Index = " + startIndex + "," + "End Index = " + endIndex);

    }
}
