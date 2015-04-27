package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s)
 * from start to end, such that:
 * 
 * 1. Only one letter can be changed at a time;
 * 2. Each intermediate word must exist in the dictionary
 * 
 * For example, given
 * 
 * start = "hit",
 * end = "cog",
 * 
 * dict = ["hot", "dot", "dog", "lot", "log", "cog"]
 * 
 * Return
 * 
 * [
 * 	["hit","hot","dot","dog","cog"],
 * 	["hit","hot","lot","log","cog"]
 * ]
 * 
 * Note:
 * - all words must have same length.
 * - all words contain only lowercase alphabetical characters.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC126_WordLadderII {
	
	private static char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l',
		'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	private static int min = Integer.MAX_VALUE;

	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		
		List<List<String>> res = new ArrayList<List<String>>();
		
		List<String> path = new ArrayList<String>();
		path.add(start);
		
		findLaddersBT(start, end, dict, path, res);
		
		List<List<String>> res2 = new ArrayList<List<String>>();
		
		for (List<String> tmp : res){
			if (tmp.size()==min){
				res2.add(tmp);
			}
		}
		
		return res2;
	}
	
	private void findLaddersBT(String start, String end, Set<String> dict, List<String> path, 
			List<List<String>> res){
		
		if (start.equals(end)){
			//path.add(start); // this would cause end word written twice in path	
			if (path.size()<=min){
				min = path.size();
				res.add(new ArrayList<String>(path));
				LeetCodeUtils.printList(path);
			}
			
			return;
		}
		
		for (int i=0; i<start.length(); i++){
			for (int j=0; j < alphabet.length; j++){
				if (start.charAt(i)!=alphabet[j]){					
					String trans = transform(start, alphabet[j], i);
					if (dict.contains(trans) && !path.contains(trans)){
						path.add(trans);
						findLaddersBT(trans, end, dict, path, res);
						path.remove(path.size()-1);
					}
				}
			}
		}
	}
	
	private String transform(String s, char c, int pos){
		
		char[] ca = s.toCharArray();
		ca[pos] = c;
		
		return String.valueOf(ca);
	}
}
