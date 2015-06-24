package com.leetcode.jyang;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 * 
 * 
 * @author jyang
 * 
 * My notes:
 * 
 * In some sense this problem is similar to Problem #70, climbing stairs. In problem 70 you
 * can climb stairs either 1 step a time, or 2 steps a time. Here in the normal cases, you 
 * can group digits one at a time, or 2 at a time.
 * 
 * The difference is that in this case, not every digits and 2-digit numbers are valid for 
 * the solution so we need to treat them differently.
 * 
 * Invalid inputs: 40, 100, 530, etc.
 * Tricky inputs: 110, 101, 1010, etc.
 */

public class LC091_DecodeWays {
	
	/**
	 * 1. 当前这个single digit arr[i]是在1~9之内，说明能组成一个字母，则当前的组合方式(d[i–1], arr[i])成功，
	 * 则d[i] = d[i–1]。不成功，则以i结尾的string没有组合方式，d[i] = 0
	 * 
     * 2. 当前这个arr[i]是能组成一个10~26的两位数的第二个digit。这样的话，当前的组合(d[i -2], “arr[i – 1]arr[i]”）
     * 成功，则d[i] += d[i – 2]。不成功也不归零，因为可能之前single digit的方式成了，所以不动这个d[i]就行了。
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		
		int[] d = new int[s.length()];
		
		if (s.charAt(0) != '0')
		    d[0] = 1;
		
		for (int i = 1; i < s.length(); i++) {
		    if (s.charAt(i) == '0')
		        d[i] = 0;
		    else
		        d[i] = d[i-1];
		    
		    int n = Integer.valueOf(s.substring(i-1, i+1));	
		    
		    if (n >= 10 && n <= 26)
		        d[i] += i > 1 ? d[i-2] : 1;
		}
		
		return d[s.length() - 1];
	}
	
	boolean canFormTwo(String s, int i, int j) {
		if (j > s.length())
		    return false;
		 
		Integer firstTwo = Integer.valueOf(s.substring(i, j));		  
		return firstTwo > 9 && firstTwo <= 26;
	}
	
	public int numDecodings2(String s) {
		
	    if (s.isEmpty() || s.charAt(0) == '0') return 0;
	    
	    // r2: decode ways of s[i-2], r1: decode ways of s[i-1] 
	    int r1 = 1, r2 = 1;

	    for (int i = 1; i < s.length(); i++) {
	        // zero voids ways of the last because zero cannot be used separately
	        if (s.charAt(i) == '0') r1 = 0;

	        // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
	        // what about 17,18 and 19?
	        if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
	            r1 = r2 + r1;
	            r2 = r1 - r2;
	        }
	        // one-digit letter, no new way added
	        else {
	            r2 = r1;
	        }
	    }

	    return r1;
	}
	
    public int numDecodings3(String s) {
   
        if (s.isEmpty() || s.charAt(0)=='0')	 return 0;
        
        int[] res = new int[s.length()+1];
        
        res[0]=1;
        res[1]=1;
        
        for (int i=1; i<s.length(); i++) {       //res[i+1] stores the count for s.charAt(i)
            
        	int digit2 = Integer.parseInt(s.substring(i-1,i+1));   //validating the integer represented by this and the previous digits
            
        	if (digit2==0) return 0;
            
        	if (digit2<=26 && digit2>=10 && (i==s.length()-1 || s.charAt(i+1)!='0'))
        		res[i+1] += res[i-1];
            
        	if (s.charAt(i)!='0') 
        		res[i+1] += res[i];                    //validating current digit
        }
        
        return res[s.length()];     
    }
 
}
