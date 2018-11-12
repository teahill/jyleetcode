package com.leetcode.jyang;

import java.util.HashSet;
import java.util.Set;

public class LC929_UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        
        if (emails==null || emails.length==0){
            return 0;
        }
        
        Set<String> res = new HashSet<String>();
        
        for (String s : emails){
            
            if (s==null || s.length()==0){
                continue;
            }
            
            String[] tmp = s.split("@");
            
            String noPlus = getPartialString(tmp[0], '+');
            if (noPlus==null || noPlus.length()==0){
                continue;
            }
            
            String first = removeChar(noPlus, '.');
            
            String whole = first + "@" + tmp[1];
            
            if (!res.contains(whole)){
                res.add(whole);
            }
        }
        
        return res.size();
    }
    
    String removeChar(String s, char c) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)!=c){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    String getPartialString(String s, char c) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)!=c){
                sb.append(s.charAt(i));
            }
            else {
                break;
            }
        }
        
        return sb.toString();
    }
	
}
