class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum speed must be at least 1
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile); // maximum pile size
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, mid, h)) {
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1; // need larger speed
            }
        }
        return left; // left will hold the minimum valid speed
    }

    public boolean canEat(int[] piles, int k, int h) {
        long hours = 0; // use long to avoid overflow
        for (int bananas : piles) {
            // ceiling division: (bananas + k - 1) / k
            hours += (bananas + k - 1) / k;
            if (hours > h) return false; // early exit if already too many hours
        }
        return hours <= h;
    }
}