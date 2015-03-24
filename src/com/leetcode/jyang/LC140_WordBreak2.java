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

	Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> dict) {
    	
        List<String> res = new ArrayList<String>();
        
		if (map.containsKey(s)){
			return map.get(s);
		}

        for (int i = 1; i <= s.length(); i++) {
        	
            String left = s.substring(0, i);
            
            if (dict.contains(left)) {
            	
                if (i == s.length()) {
                    res.add(left);
                } 
                else {
                    String right = s.substring(i);               
                    List<String> rightRes = wordBreak(right, dict);
                            
                    if (rightRes != null) {
                        for (String item : rightRes) {
                            res.add(left + " " + item);
                        }
                        map.put(right, rightRes);
                    }  
                }
            }
        }
        return res;
    }
	
	public List<String> wordBreak2(String s, Set<String> dict) {
		
		List<String> res = new ArrayList<String>();
		
		if (s.isEmpty()){
			return res;
		}

		if (map.containsKey(s)){
			return map.get(s);
		}
		
//		if (dict.contains(s)){
//			res.add(s);
//			map.put(s, res);
//			return res;
//		}
		
		for (int i=1; i<=s.length(); i++){
			
			String left = s.substring(0, i);
			
			if (dict.contains(left)){	
				
				if (left.length()==s.length()){
					res.add(left);
				}
				else {
					List<String> rRes = wordBreak(s.substring(i), dict);				
					
					if (rRes!=null){
						
						for (String word : rRes){						
							StringBuilder sb = new StringBuilder();						
							sb.append(left).append(" ");
							sb.append(word).append(" ");						
							res.add(sb.toString().trim());
						}
						
						map.put(s.substring(i), res);
					}
				}
			}			
		}		
		
		return res;
	}
}
