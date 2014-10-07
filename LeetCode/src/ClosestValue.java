/**
 * Created by kkwang on 8/18/2014.
 */
public class ClosestValue {
    public static int findNearestValue(int[] arr, int value) {
        int mid;
        int low = 0, high = arr.length-1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (value < arr[mid])
                high = mid - 1;
            else if (value > arr[mid])
                low = mid + 1;
            else
                return arr[mid];
        }

        int diffLow = Math.abs(value - arr[low]);
        int diffHigh = Math.abs(value - arr[high]);
        return (diffLow < diffHigh) ? arr[low] : arr[high];
    }

    public static int findClosestValue(int[] arr, int x) {
        int low = 0, high = arr.length-1;
        int mid = 0;
        while(low < high) {
            mid = (high-low)/2 + low;
            if(arr[mid] == x) return arr[mid];
            if(Math.abs(arr[mid] - x) <= Math.abs(arr[mid+1] - x))
                high = mid;
            else
                low = mid+1;
        }
        return arr[high];
    }

    public static void main(String[] args) {
        int[] a = {0, 3, 5, 7, 9};
        int n = findClosestValue(a, 2);
        System.out.println(n);

        n = findNearestValue(a, 2);
        System.out.println(n);
    }

    // This function prints k closest elements to x in arr[].
    // n is the number of elements in arr[]
    void printKClosest(int arr[], int x, int k) {
        // Find the crossover point
        int l = findNearestValue(arr, x);
        int r = l + 1;   // Right index to search
        int count = 0; // To keep track of count of elements already printed

        // If x is present in arr[], then reduce left index since output should not include x
        // Assumption: all elements in arr[] are distinct
        if (arr[l] == x) l--;

        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < arr.length && count < k) {
            if (x - arr[l] < arr[r] - x)
                System.out.println(arr[l--]);
            else
                System.out.println(arr[r++]);
            count++;
        }

        // If there are no more elements on right side, then
        // print left elements
        while (count < k && l >= 0) {
            System.out.println(arr[l--]);
            count++;
        }

        // If there are no more elements on left side, then
        // print right elements
        while (count < k && r < arr.length) {
            System.out.println(arr[r++]);
            count++;
        }
    }
}
