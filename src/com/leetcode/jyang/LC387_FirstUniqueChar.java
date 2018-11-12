package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC387_FirstUniqueChar {
	
    public int firstUniqChar(String s) {
    	
        if (s==null || s.length()==0){
            return -1;
        }
        
        Map<Character, PosCount> map = new HashMap<Character, PosCount>();
        
        for (int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            PosCount pc = map.get(c);
            
            if (pc!=null){
                pc.count++;
                //map.put(c, pc);
            }
            else {
                map.put(c, new PosCount(i, 1));
            }
        }
            
        int minPos = s.length();
            
        Iterator<PosCount> itr = map.values().iterator();
            
        while (itr.hasNext()){
            PosCount tmp = itr.next();
                
            if (tmp.count==1){
                minPos = Math.min(minPos, tmp.pos);
            }
        }
        
        if (minPos == s.length()){
            return -1;
        }
        
        return minPos;
    }
    
    private static class PosCount {
        int pos;
        int count;
        
        PosCount(int p, int c){
            pos = p;
            count = c;
        }
    }
}
