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
	public void testLC202(){
		
		trace();
		
		LC202_HappyNumber lc202 = new LC202_HappyNumber();
		
		int[] input = new int[] {
				19,
				21,
		};
		
		for (Integer n : input){
			System.out.println("Number: " + n + " is happy numder? " + lc202.isHappy(n));
		}
	}
	
	//@Test
	public void testLC203(){
		
		trace();
		
		LC203_RemoveLinkedListElements lc202 = new LC203_RemoveLinkedListElements();
		
		int[][] lists = new int[][] {
				{6,1,2,6,3,4,5,6},
				{6,6,6,6,6,6},
		};
		
		int[] vals = new int[]{
				6,
				6,
		};
		
		for (int i=0; i<lists.length; i++){
			LeetCodeUtils.printIntArray(lists[i]);
			ListNode head = LeetCodeUtils.buildList(lists[i]);
			head = lc202.removeElements(head, vals[i]);
			LeetCodeUtils.printlist(head);
		}	
	}
	
	@Test
	public void testLC204(){
		
		trace();
		
		LC204_CountPrimes lc204 = new LC204_CountPrimes();
		
		int[] input = new int[] {
				2,
				10,
				100,
				200,
				//999983,
		};
		
		for (Integer n : input){
			System.out.println("Number of primes < " + n + "=" + lc204.countPrimes(n));
		}
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
	public void testLC223(){
		
		trace();
		
		int[][] input = new int[][]{
				{-4,-4,4,4,-3,-3,3,3},  // b in a
				{-4,-4,4,4,-5,-5,5,5},	// a in b
				{-4,-4,4,4,2,2,5,5},	// separate
				{-3,0,3,4,0,-1,9,2},   	// overlapping a corner
				
				{-6,1,-1,3,-2,-1,7,4},	// section, a in b, left 
				{5,1,10,3,-2,-1,7,4},	// section, a in b, right 
				{1,3,5,6,-2,-1,7,4},	// section, a in b, up 
				{1,-4,4,1,-2,-1,7,4},	// section, a in b, bottom 
				
				{-2,-1,7,4,-6,1,-1,3},	// section, b in a, left 
				{-2,-1,7,4,5,1,10,3,},	// section, b in a, right 
				{-2,-1,7,4,1,3,5,6,},	// section, b in a, up 
				{-2,-1,7,4,1,-4,4,1},	// section, b in a, bottom 
			};
		
		LC223_RectangleArea lc223 = new LC223_RectangleArea();
		
		for (int i=0; i<input.length; i++){
			int area = lc223.computeArea(input[i][0], input[i][1], input[i][2], input[i][3], 
							input[i][4], input[i][5], input[i][6], input[i][7]);
			System.out.println("Case #" + (i+1) + " area=" + area);
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
	
	//@Test
	public void testLC228(){
		
		trace();
		
		int[][] input = new int[][]{
				{0,1,2,4,5,7},
				{0,2,3,4,6,7,9},
				{1,1,1,1},
		};
		
		LC228_SummaryRanges lc228 = new LC228_SummaryRanges();
		
		for (int[] nums : input){
			List<String> res = lc228.summaryRanges(nums);
			LeetCodeUtils.printList(res);
		}
		
	}
	
}
