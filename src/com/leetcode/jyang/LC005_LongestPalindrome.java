package com.leetcode.jyang;

/**
 * Level: Medium
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of
 * S is 1000, and there exists one unique longest palindromic substring.
 * 
 * @author jyang
 *
 */

public class LC005_LongestPalindrome {

	public String longestPalindrome(String s) {

		// we have 2 patterns of palindromes: madam, and anna.
		int left = 0;
		int right = 0;
		
		int[] result = new int[2];
		
		int maxlen = 0;
		
		for (int i=0; i<s.length(); i++){

			left = i;
			right = i;
			
			while (true){
				// pattern 1
				if (left-1>=0 && right+1<=s.length()-1 && s.charAt(left-1)==s.charAt(right+1)){		
					left--;
					right++;
				}
				// pattern 2
				else if (left>=0 && right+1<=s.length()-1 && s.charAt(left)==s.charAt(right+1)){
					if (isSymmetric(s, left, right+1)){
						right++;
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			
			int len = right - left + 1;
			
			if (len > maxlen){
				maxlen = len;
				result[0] = left;
				result[1] = right;
			}
		}
	      
		return s.substring(result[0], result[1]+1);
	}
	
	private boolean isSymmetric(String s, int left, int right) {
		
		if (s.length()<=1){
			return true;
		}
		
		int len = right - left + 1;
		int mid = len/2 + left;
		
		if (len%2==0){
			return s.charAt(mid)==s.charAt(mid-1);
		}
		else {
			return s.charAt(mid+1)==s.charAt(mid-1);
		}
	}
    	
	public static void main(String[] args) {
		
		String[] inputs = new String[] {
			"madamimadam",
			"maam",
			"aaaa",
			"dhajgmadamimadamfhdhldk",
			"aaabaaaa",
			"jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel",
			"ihzttzi",
			"bb",
			"fkwwkkf"
		};
		
		LC005_LongestPalindrome lc005 = new LC005_LongestPalindrome();
			
		for (String s : inputs) {
			
			String s2 = s.length()>50? s.substring(0, 49) + "..." : s;
			
			System.out.println("Longest palindrome in " + s2 + ": " + lc005.longestPalindrome(s));
		}

	}
}
