package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word
 * is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author jyang
 *
 */

public class LC140_WordBreak2 {
	
	private static int count = 0;

	Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> wordBreak(String s, Set<String> dict) {
		
	   	String[] a = new String[dict.size()];
    	dict.toArray(a);
		
    	long start = System.currentTimeMillis();
    	
    	List<String> r = wordBreakInt(s, a, dict);
    	
    	long end = System.currentTimeMillis();
    	
    	System.out.println("**** # of Recursive calls: " + count);
    	System.out.println("**** time used: " + (end - start));
    	System.out.println("**** hashmap size: " + map.size());
    	
    	return r;
	}
	
    public List<String> wordBreakInt(String s, String[] a, Set<String> dict) {
    	
    	count++;
    	
    	//System.out.println("Trying to break: ->" + s + "<-");
        
    	List<String> res = new ArrayList<String>();
    	
    	if (s==null || s.isEmpty()){
    		return res;
    	}
    	
    	if (map.containsKey(s)){
//    		System.out.println("Found in map for: " + s);
    		return map.get(s);
    	}
    	
    	if (dict.contains(s) && !res.contains(s)){
    		res.add(s);
       		map.put(s, res);
    		return res;
    	}
    	    	
    	for (int i=0; i<a.length; i++){
    		
    		int start = s.indexOf(a[i]);
    		
    		if (start>=0){    
    			
    			String lstr = s.substring(0, start);
    			String rstr = s.substring(start + a[i].length(), s.length());
    			
    			List<String> left = wordBreakInt(lstr, a, dict);
  			
    			List<String> right = wordBreakInt(rstr, a, dict);
    			
    			boolean leftOk = (lstr.isEmpty() == left.isEmpty());
    			boolean rightOk = (rstr.isEmpty() == right.isEmpty());
    			
//    			System.out.println("\ns=" + s);
//       			System.out.println("a[i]=" + a[i]);
//    			System.out.println("lstr=" + lstr);
//    			LeetCodeUtils.printList(left);    			
//    			System.out.println("rstr=" + rstr);
//    			LeetCodeUtils.printList(right);
    			
//    			if (left.size()==1 && right.size()==1){
//    			if (!left.isEmpty() && !right.isEmpty()){
    			if (leftOk && rightOk){
    				StringBuilder sb = new StringBuilder();
    				for (String str : left){
    					sb.append(str).append(" ");
    				}
    
    				sb.append(a[i]).append(" ");
       				
    				for (String str : right){
    					sb.append(str).append(" ");
    				}
    				
    				String tmp = sb.toString().trim();
    				
    				if (!res.contains(tmp)){
    					res.add(tmp);
    				}
    				
//    				System.out.println("----->Partial solution: ");
//    				LeetCodeUtils.printList(res);
    			}
    			else {
//    				System.out.println("----->No Partial solution! ");
    			}
    			
//    			System.out.println("Put partial solution in map for: " + s);
    			map.put(s, res);
    		}
    	}

    	return res;
    }
	
    public List<String> wordBreak2(String s, Set<String> dict) {
        
    	List<String> res = new ArrayList<String>();
    	
    	String[] a = new String[dict.size()];
    	dict.toArray(a);
    	
    	if (s==null || s.isEmpty()){
    		return res;
    	}
    	
    	if (dict.contains(s)){
    		res.add(s);
    		return res;
    	}
    	    	
    	for (int i=0; i<a.length; i++){
    		
    		int start = s.indexOf(a[i]);
    		
    		if (start>=0){    
    			
    			List<String> left = wordBreak2(s.substring(0, start), dict);
    			List<String> right = wordBreak2(s.substring(start + a[i].length(), s.length()), dict);
    			
    			System.out.println("\ns=" + s);
				//System.out.println("lstr=" + s.substring(0, start));
				LeetCodeUtils.printList(left);    	
	   			System.out.println("a[i]=" + a[i]);
				//System.out.println("rstr=" + s.substring(start + a[i].length(), s.length()));
				LeetCodeUtils.printList(right);
    			
    			if (left.size()==1 && right.size()==1){
    				
    				StringBuilder sb = new StringBuilder();
    				for (String str : left){
    					sb.append(str).append("+");
    				}
    				sb.append(a[i]).append("+");
       				for (String str : right){
    					sb.append(str).append("+");
    				}
    				res.add(sb.toString().trim());
    				System.out.print("--->");
    				LeetCodeUtils.printList(res); 
    			}
    		}
    	}
    	
    	return res;
    	
    }
}
