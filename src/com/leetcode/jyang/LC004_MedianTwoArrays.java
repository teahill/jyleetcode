package com.leetcode.jyang;

/**
 * Level: Hard
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * @author jyang
 * 
 * https://leetcode.com/discuss/41621/very-concise-iterative-solution-with-detailed-explanation
 *
 */

public class LC004_MedianTwoArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if (n1 < n2) return findMedianSortedArrays(nums2, nums1);   // Make sure A is the shorter one.

        if (n2 == 0) return ((double)nums1[(n1-1)/2] + (double)nums1[n1/2])/2;  // If B is empty

        int lo = 0, hi = n2 * 2;
        
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;   // Try Cut 2 
            int mid1 = n1 + n2 - mid2;  // Calculate Cut 1 accordingly

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];  // Get l1, l1, l2, r2 respectively
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double r1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
            double r2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];

            if (l1 > r2) 
            	lo = mid2 + 1;     // A1's lower half is too big; need to move C1 left (C2 right)
            else if (l2 > r1) 
            	hi = mid2 - 1;    // A2's lower half too big; need to move C2 left.
            else 
            	return (Math.max(l1,l2) + Math.min(r1, r2)) / 2; // Otherwise, that's the right cut.
        }
        
        return -1.0d;
    }
    
    // using divide and conquer idea, each time find the mid of both arrays
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            
    	/* A[0, 1, 2, ..., n-1, n] */
        /* A[0, 1, 2, ..., m-1, m] */   	
    	int m = nums1.length;
    	int n = nums2.length;
	
        int k = (m + n + 1) / 2;
        double v = (double)FindKth(nums1, 0, m - 1, nums2, 0, n - 1, k);

        if ((m+n) % 2 == 0) {
            int k2 = k+1;
            double v2 = (double)FindKth(nums1, 0, m - 1, nums2, 0, n - 1, k2);
            v = (v + v2) / 2;
        }

        return v;
    }

    // find the kth element in the two sorted arrays
    // let us say: A[aMid] <= B[bMid], x: mid len of a, y: mid len of b, then we can know
    // 
    // (1) there will be at least (x + 1 + y) elements before bMid
    // (2) there will be at least (m - x - 1 + n - y) = m + n - (x + y +1) elements after aMid
    // therefore
    // if k <= x + y + 1, find the kth element in a and b, but unconsidering bMid and its suffix
    // if k > x + y + 1, find the k - (x + 1) th element in a and b, but unconsidering aMid and its prefix
    int FindKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
        if (aL > aR) return B[bL + k - 1];
        if (bL > bR) return A[aL + k - 1];

        int aMid = (aL + aR) / 2;
        int bMid = (bL + bR) / 2;

        if (A[aMid] <= B[bMid]) {
            if (k <= (aMid - aL) + (bMid - bL) + 1) 
                return FindKth(A, aL, aR, B, bL, bMid - 1, k);
            else
                return FindKth(A, aMid + 1, aR, B, bL, bR, k - (aMid - aL) - 1);
        }
        else { // A[aMid] > B[bMid]
            if (k <= (aMid - aL) + (bMid - bL) + 1) 
                return FindKth(A, aL, aMid - 1, B, bL, bR, k);
            else
                return FindKth(A, aL, aR, B, bMid + 1, bR, k - (bMid - bL) - 1);
        }
    }
}
