package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139_WordBreak2 {
	
	// official DP solution
    public boolean wordBreak(String s, List<String> wordDict) {
    	
        Set<String> wordDictSet=new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	System.out.println("i=" + i);
            for (int j = 0; j < i; j++) {
            	System.out.println("\tj=" + j);
            	System.out.println("\tsubstring=" + s.substring(j, i));
//            	System.out.println("\ti: dp[" + i + "]=" + dp[i]);
//            	System.out.println("\tj: dp[" + j + "]=" + dp[j]);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    printArray(dp);
                    break;
                }
                printArray(dp);
            }
        }
        return dp[s.length()];
    }
	
	// this is not working
    public boolean wordBreak3(String s, List<String> wordDict) {
        
        if (s==null || s.length()==0) {
            return true;
        }
        
        int pe = 0;
        
        while (pe <=s.length()) {
            
            String tmp = s.substring(0, pe);
            
            if (wordDict.contains(tmp)){
                return wordBreak(s.substring(pe), wordDict);
            }
            else {
                pe++;
            }
        }
        
        return false;
    }
    
    public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
        	System.out.println(s.substring(start, end));
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
    
    private void printArray(boolean[] a) {
    	
    	for (int i=0; i<a.length; i++) {
    		System.out.print("[" + i + ":" + a[i] + "] ");
    		
    	}
    	
    	System.out.println();
    }

    public static void main(String[] args) {
    	
    	LC139_WordBreak2 lc139 = new LC139_WordBreak2();
    	 
    	List<String> dict = new ArrayList<String>();
    	
//    	dict.add("leet");
//    	dict.add("code");
//    	String s = "leetcodeleet";
    	
    	dict.add("aaaa");
    	dict.add("aaa");
    	String s = "aaaaaaa";
    	
    	boolean b = lc139.wordBreak(s, dict);
    	
    	System.out.println(b);
    }

}
