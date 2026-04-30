/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();

        // Find peak
        int l = 0, r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < arr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int peak = l;

        // Left search (ascending)
        l = 0; 
        r = peak;
        while (l <= r) {
            int m = (l + r) / 2;
            int v = arr.get(m);
            if (v == target) return m;
            if (v < target) l = m + 1;
            else r = m - 1;
        }

        // Right search (descending)
        l = peak + 1; 
        r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int v = arr.get(m);
            if (v == target) return m;
            if (v > target) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}