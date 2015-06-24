package com.leetcode.jyang;

/**
 * implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 * 
 * 
 * @author jyang
 *
 */

public class LC069_SquareRoot {
	
	public int mySqrt(int x) {

		if(x<=1) return x;

		int left=0, right=x, mid;

		while( (right-left)>1 )
		{
			mid=left+(right-left)/2;

			if(mid==x/mid)
				return mid;
			else if (x/mid < mid)
				right=mid;
			else
				left=mid;
		}

		return left; // not 'right' as it is rounding down
	} 
	
    public int mySqrt2(int x) {
    	
        if (0 == x) return 0;
        
        int left = 1, right = x, ans = 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
	
}
