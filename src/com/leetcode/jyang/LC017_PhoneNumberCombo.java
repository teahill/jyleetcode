package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Level: Medium
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * @author jyang
 *
 */
public class LC017_PhoneNumberCombo {
	
	private static Map<Character, String[]> keys = new HashMap<Character, String[]>();
	
	static {
		keys.put('2', new String[]{"a", "b", "c"});
		keys.put('3', new String[]{"d", "e", "f"});
		keys.put('4', new String[]{"g", "h", "i"});
		keys.put('5', new String[]{"j", "k", "l"});
		keys.put('6', new String[]{"m", "n", "o"});
		keys.put('7', new String[]{"p", "q", "r", "s"});
		keys.put('8', new String[]{"t", "u", "v"});
		keys.put('9', new String[]{"w", "x", "y", "z"});
	}
	
	public List<String> letterCombinations(String digits) {
		
		List<String> res = new ArrayList<String>();
		
		if (digits==null || digits.isEmpty()){
			return res;
		}
		
		return getCombo(digits, 0);
	}
	
	public List<String> getCombo(String digits, int pos){
		
		List<String> res = new ArrayList<String>();
		
		if (pos>=digits.length()){
			return res;
		}
		
		String[] chars = keys.get(digits.charAt(pos));
		if (chars==null){
			return res;
		}
		
		pos++;
		List<String> coms = getCombo(digits, pos);
		
		for (int i=0; i<chars.length; i++){
			String c = chars[i];
			
			if (coms.isEmpty()){
				res.add(c);
			}
			else {
				for (String s : coms){
					res.add(c+s);
					res.remove(s);
				}
			}
		}
		
		return res;
	}
}
