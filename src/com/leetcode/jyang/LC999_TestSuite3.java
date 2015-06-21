package com.leetcode.jyang;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LC999_TestSuite3 {

    @BeforeClass
    public static void oneTimeSetUp() {
    }
 
    @AfterClass
    public static void oneTimeTearDown() {
    }
 
    @Before
    public void setUp() {
    }
 
    @After
    public void tearDown() {
    }
	
    private void trace(){    	
		//System.out.println("Executing test case: " + new Object(){}.getClass().getEnclosingMethod().getName());
    	StackTraceElement[] trace = Thread.currentThread().getStackTrace();    	
    	System.out.println("---> Executing test case: " + trace[2].getMethodName());
    }
	
	//@Test
	public void testLC213(){
		
		trace();
		
		int[][] input = new int[][]{
			{6,5,2,2,7,28,3,0,9,2,8},
			{5,6,2,2,7,28,3,0,9,2,8},	
		};
		
		LC213_HouseRobberII lc213 = new LC213_HouseRobberII();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			int loot = lc213.rob(input[i]);
			System.out.println("Loot amount = " + loot);
		}
	}
	
	//@Test
	public void testLC217(){
		
		trace();
		
		int[][] input = new int[][]{
			{6,5,2,2,7,28,3,0,9,2,8},
			{1,2,3,4,5,6,7,8,9},	
		};
		
		LC217_ContainsDuplicate lc217 = new LC217_ContainsDuplicate();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("Contains duplicate? " + lc217.containsDuplicate(input[i]));
		}
	}
	
	//@Test
	public void testLC219(){
		
		trace();
		
		int[][] input1 = new int[][]{
			{6,5,2,7,28,2,0,9,3,8},
			{6,5,2,7,28,3,0,9,2,8},
			{1,0,1,1},
		};
		
		int[] input2 = new int[]{
			3,
			3,
			1
		};
			
		LC219_ContainsDuplicateII lc219 = new LC219_ContainsDuplicateII();
		
		for (int i=0; i<input1.length; i++){
			LeetCodeUtils.printIntArray(input1[i]);
			System.out.println("Contains duplicate? " + lc219.containsNearbyDuplicate(input1[i], input2[i]));
		}
	}
	
	//@Test
	public void testLC220(){
		
		trace();
		
		int[][] input1 = new int[][]{
			{6,5,2,7,28,2,0,9,3,8},
			{6,5,2,7,28,3,0,9,2,8},
			{1,0,1,1},
			{-1,-1},
			{-1,-1},
			{-3,3},
		};
		
		int[] input2 = new int[]{
			3,
			3,
			1,
			1,
			1,
			2,
		};
		
		int[] input3 = new int[]{
			3,
			3,
			1,
			0,
		   -1,
			4
		};
			
		LC220_ContainsDuplicateIII lc220 = new LC220_ContainsDuplicateIII();
		
		for (int i=0; i<input1.length; i++){
			LeetCodeUtils.printIntArray(input1[i]);
			System.out.println("Contains duplicate? " + 
					lc220.containsNearbyAlmostDuplicate(input1[i], input2[i], input3[i]));
		}
	}
    
	//@Test
	public void testLC226(){
		
		trace();
		
		String tree = "4,2,7,1,3,6,9";		
		//String tree = "4,2,7,1,#,6,9";
		TreeNode root = LeetCodeTreeUtils.deserilizeBinaryTree(tree);
		LeetCodeTreeUtils.printTreeByLevel(root);
		
		LC226_InvertBinaryTree lc226 = new LC226_InvertBinaryTree();
		lc226.invertTree(root);
		LeetCodeTreeUtils.printTreeByLevel(root);
	}
	
}
