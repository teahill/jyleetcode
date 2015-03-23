package com.leetcode.jyang;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * 1 1 2 2 3
 * 
 * @author jyang
 *
 */

public class LC080_RemoveDupArray2 {

	public int removeDuplicates(int[] A) {
		
		if (A==null || A.length<3){
			return A.length;
		}
		
		int count = 0;
		int tmp = 0;
		
		for (int i=2; i<A.length; i++){		
			if (A[i]==A[i-1] && A[i-1]==A[i-2]){
				count++;
				System.out.println("->" + A[i-2] + " " + A[i-1] + " " + A[i]);
				System.out.println("count=" + count);
			}
			else {
				A[i-count] = A[i];
				tmp = i-count;
			}
			
			LeetCodeUtils.printIntArray(A);
		}
		
		return A.length - count;
	}
	
	public int removeDuplicates2(int[] A){
		
		int p1=1;
		int p2=1;
		
		int count1 = 0;
		int count2 = 0;

		while (p2<A.length && p1<A.length){
			
			count2 = 0;

			while (p2<A.length && A[p2]==A[p2-1]){
				p2++;
				count1++;
			}
			
			while (p1<A.length && A[p1]==A[p1-1]){
				p1++;
				count2++;
				if (count2==1){
					break;
				}
			}
			
			LeetCodeUtils.printIntArray(A);
			
			if (p2<A.length && p1<A.length){
				A[p1]=A[p2];
			}
			
			LeetCodeUtils.printIntArray(A);
			
			p1++;
			p2++;
		}
		
		LeetCodeUtils.printIntArray(A);
		
		return A.length;
	}
	
}
