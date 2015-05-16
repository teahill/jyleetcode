package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.*;

public class LC999_TestSuite {
	
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
	public void testLC006() {
		
		trace();
		
	   	char[][] matrix = new char[3][5];
	   	
	   	for (int i=0; i<matrix.length; i++){
	   		
	   		for (int j=0; j<matrix[i].length; j++){
	   			matrix[i][j]= 'A';
	   		}
	   	}
	   	
	   	for (int i=0; i<matrix.length; i++){
	   		
	   		for (int j=0; j<matrix[i].length; j++){
	   			System.out.print((int)(matrix[i][j]) + " ");
	   		}
	   		System.out.println();
	   	}
	}
	
	//@Test
	public void testLC011(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,2,1,4,2},
				{2,5,4,3,7},
				{9,4,3,0,8},
				{5,2,12,1,5,3,4,11,9,4}
			};
			
			LC011_WaterContainer lc011 = new LC011_WaterContainer();
			
			for (int i=0; i<input.length; i++){
				System.out.println("Max area of input: is " + lc011.maxArea(input[i]));
			}
	}
	
	//@Test
	public void testLC012() {
		
		trace();
		
		int[] input = new int[] {
				1,
				4,
				5,
				8,
				9,
				10,
				11,
				14,
				15,
				20,
				28,
				40,
				45,
				90,
				97,
				100,
				143,
				493,
				500,
				876,
				2071,
				3999			
			};
		
		LC012_Integer2Roman lc012 = new LC012_Integer2Roman();
		LC013_Roman2Integer lc013 = new LC013_Roman2Integer();
		
		for (int i=0; i<input.length; i++){
			String s = lc012.intToRoman(input[i]);
			System.out.println("Convert to Roman of " + input[i] + " is " + s);
			System.out.println("Convert from Roman of " + s + " is " + lc013.romanToInt(s));
		}
	}
	
	//@Test
	public void testLC014(){
		
		trace();
		
		String[] inputs = new String[] {
				"abcdef",
				"abc123",
				"ab",
//				"",
				"xcv"
			};
			
		LC014_LongestCommonPrefix lc014 = new LC014_LongestCommonPrefix();
				
		System.out.println("Longest common prefix in :" + lc014.longestCommonPrefix(inputs));
		
	}
	
	//@Test
	public void testBinarySearch(){
		
		trace();
		
		int[] num = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		
		LC015_3Sum lc015 = new LC015_3Sum();
		
		Arrays.sort(num);
		
		int i = lc015.binarySearch(num, 0, num.length-1, 2);
		
		System.out.println(i);
	}
	
	//@Test
	public void testLC015(){
		
		trace();
		
		int[][] input = new int[][] {
			{-1, 0, 1, 2, -1, -4},
			{-1, 0, 1},
			{0, 0, 0},
			{1, 1, 1},
			{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6},
			{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6},				
		};
			
		LC015_3Sum lc015 = new LC015_3Sum();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			List<List<Integer>> result = lc015.threeSum(input[i]);
			System.out.println("Results for input set: size = " + result.size());
			for (List<Integer> r : result){
				LeetCodeUtils.printList(r);
			}

		}
	}
	
	//@Test
	public void testLC016(){
		
		trace();
		
		int[][] input = new int[][] {
			{-1, 2, 1, -4},
			{0,0,0}
		};
		
		int[] input2 = new int[] {
			1,
			1
		};
			
		LC016_3SumClosest lc016 = new LC016_3SumClosest();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("Results for input set: " + lc016.threeSumClosest(input[i], input2[i]));
		}
	}
	
	//@Test
	public void testLC017(){
		
		trace();
		
		String[] input = new String[]{
			"23346"
		};
		
		LC017_PhoneNumberCombo lc017 = new LC017_PhoneNumberCombo();
		
		for (String s : input){
			List<String> res = lc017.letterCombinations(s);
			LeetCodeUtils.printList(res);
		}
	}
	
	//@Test
	public void testLC018(){
		
		trace();
		
		int[][] input = new int[][] {
			{0,0,0,0},
//			{1, 0, -1, 0, -2, 2},
//			{-3,-2,-1,0,0,1,2,3}
			{-4,-3,-2,-1,0,0,1,2,3,4},
		};
		
		LC018_4Sum lc018 = new LC018_4Sum();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			List<List<Integer>> result = lc018.fourSum(input[i], 0);
			System.out.println("Results for input set");
			for (List<Integer> r : result){
				LeetCodeUtils.printList(r);
			}

		}
	}
	
	//@Test
	public void testLC019(){
		
		trace();
		
		int[] input = new int[]{1,2,3,4,5};
		int n = 7;
		
		ListNode head = LeetCodeUtils.buildList(input);
		
		LC019_RemoveNthNode lc019 = new LC019_RemoveNthNode();
		
		head = lc019.removeNthFromEnd(head, n);
		
		LeetCodeUtils.printlist(head);
	}
	
	//@Test
	public void testLC020(){
		
		trace();
		
		String[] s = new String[]{
			"(){}[]()",
			"{]()]]",
			"{}][",
			"({[]})",
			"[",
			"(("
		};
		
		LC020_ValidParentheses lc020 = new LC020_ValidParentheses();
		
		for (String str : s) {
			System.out.println("Input: " + str + " is " + (lc020.isValid(str) ? "valid" : "invalid"));
		}
	}
	
	//@Test
	public void testLC021(){
		
		trace();
		
		ListNode l1 = LeetCodeUtils.buildList(new int[]{1,3,4,6,9,23,28});	
		ListNode l2 = LeetCodeUtils.buildList(new int[]{1,2,4,7,10,25,28});
		
		LC021_MergeTwoLists lc021 = new LC021_MergeTwoLists();
		
		LeetCodeUtils.printlist(lc021.mergeTwoLists(l1, l2));	
	}	
	
	//@Test
	public void testLC022(){
		
		trace();
		
		int[] input = new int[] {
//				1,
//				2,
				3,
//				4,
//				5,
			};
			
		LC022_GenerateParnenthese lc022 = new LC022_GenerateParnenthese();
			
		for (int i=0; i<input.length; i++) {
			List<String> r = lc022.generateParenthesis(input[i]);
			System.out.println("Input: " + input[i] + " result size = " + r.size());
 			LeetCodeUtils.printList(r);
		}
	}
	
	//@Test
	public void testLC025(){
		
		trace();
		
		int[][] input = new int[][] {
//				{1,2,3,4,5,6,7,8},
				{1,2,3,4,5,6,7,8,9},
//				{1,2},
//				{1}
		};
		
		LC025_ReverseKGroup lc025 = new LC025_ReverseKGroup();
		
		for (int i=0; i<input.length; i++) {
			ListNode head = LeetCodeUtils.buildList(input[i]);
			LeetCodeUtils.printlist(head);
			
			head = lc025.reverseList(head, 2);
			LeetCodeUtils.printlist(head);
		}
	}	
	
	//@Test
	public void testLC026(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,2,3,4,4,5,6,7,7,8},
				{1,1,2,3,4,4,5,6,7,7,8,8},
				{1,1,2,3,4,4,5,6,7,7,8,8,9},
//				{1,2},
//				{1}
		};
		
		LC026_RemoveDupFromSortedArray lc026 = new LC026_RemoveDupFromSortedArray();
		
		for (int i=0; i<input.length; i++) {
			System.out.println("Array before removing duplicates:");
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("Array after removing duplicates:");
			int len = lc026.removeDuplicates(input[i]);
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("New length is: " + len);
		}
	}
	
	//@Test
	public void testLC027(){
		
		trace();
		
		LC027_RemoveElement lc027 = new LC027_RemoveElement();
		
		int[] A = new int[]{1,1,2,3,4,4,5,6,7,7,8,8,9};
		
		lc027.removeElement(new int[]{1,1,2,3,4,4,5,6,7,7,8,8,9}, 4);
		
		LeetCodeUtils.printIntArray(A);
	}
	
	//@Test
	public void testLC028(){
		
		trace();
		
		String[][] input = new String[][]{
			{"The quick brown fox jumps over the lazy dog", "dog"},
			{"mississippi", "issipi"},
			{"a", "a"},
			{"mississippi", "pi"},
			{"abcddef", "def"}
		};
		
		LC028_strStr lc028 = new LC028_strStr();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Needle:" + input[i][1] + " in hatstack: " + input[i][0] +
					"? " + lc028.strStr(input[i][0], input[i][1]));
		}
	}
	
	//@Test
	public void testLC024(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,2,3,4,5,6,7,8},
				{1,2,3,4,5,6,7,8,9},
				{1,2},
				{1}
		};
		
		LC024_SwapPairs lc024 = new LC024_SwapPairs();
		
		for (int i=0; i<input.length; i++) {
			ListNode head = LeetCodeUtils.buildList(input[i]);
			LeetCodeUtils.printlist(head);
			
			head = lc024.swapPairs(head);
			LeetCodeUtils.printlist(head);
		}
	}
	
	//@Test
	public void testLC032(){
		
		trace();
		
		String[] input = new String[]{
				"(()",
				")()())",
				"()(()"
			};
			
		LC032_LongestValidParentheses lc032 = new LC032_LongestValidParentheses();
			
		for (int i=0; i<input.length; i++){
			System.out.println("Longest valid parentheses in " + input[i] + ": " + 
					lc032.longestValidParentheses(input[i]));
		}
	}	
	
	//@Test
	public void testLC034(){
		
		trace();
		
		int[][] input = new int[][] {
				{5, 7, 7, 8, 8, 10},
				{1,2,3,4,5,6,7,8,9},
				{1,2},
				{1}
		};
		
		int[] input2 = new int[] {
				10,
				9,
				1,
				1
		};
		
		LC034_SearchInRange lc034 = new LC034_SearchInRange();
		
		for (int i=0; i<input.length; i++) {
			LeetCodeUtils.printIntArray(input[i]);
			
			int[] r = lc034.searchRange(input[i], input2[i]);
			LeetCodeUtils.printIntArray(r);
		}
	}
	
	//@Test
	public void testLC035(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,3,5,6},
				{1,3,5,6},
				{1,3,5,6},
				{1,3,5,6},		
				{1, 3},
		};
		
		int[] input2 = new int[] {
			5,
			2,
			7,
			0,
			2,
		};
		
		LC035_SearchInsertPos lc035 = new LC035_SearchInsertPos();
		
		for (int i=0; i<input.length; i++) {
			
			LeetCodeUtils.printIntArray(input[i]);
			
			int r = lc035.searchInsert(input[i], input2[i]);
			System.out.println("Insert position in input array" + " for " + input2[i] + " is " + r);
		}
	}	
	
	//@Test
	public void testLC037_1(){
		
		trace();
		
	    int[][] sudoko = new int[][] {
	    	           {5,3,0,0,7,0,0,0,0},
	    	           {6,0,0,1,9,5,0,0,0},
	    	           {0,9,8,0,0,0,0,6,0},
	    	           {8,0,0,0,6,0,0,0,3},
	    	           {4,0,0,8,0,3,0,0,1},
	    	           {7,0,0,0,2,0,0,0,6},
	    	           {0,6,0,0,0,0,2,8,0},
	    	           {0,0,0,4,1,9,0,0,5},
	    	           {0,0,0,0,8,0,0,7,9}
	    	      };
	    
	    System.out.println("char[][] sudoko = new char[][]{");
	    
	    for (int i = 0; i<sudoko.length; i++){
	    	
	    	System.out.print("\t{");
	    	int[] row = sudoko[i];
	    	
	    	for (int j = 0; j<row.length; j++){
	    		System.out.print("'" + row[j]+ "',");
	    	}
	    	System.out.println("},");
	    }
	    System.out.println("};");
	}
	
	//@Test
	public void testLC036(){
		
		trace();
		
		char[][] sudoko = new char[][]{
				{'5','3','0','0','7','0','0','0','0',},
				{'6','0','0','1','9','5','0','0','0',},
				{'0','9','8','0','0','0','0','6','0',},
				{'8','0','0','0','6','0','0','0','3',},
				{'4','0','0','8','0','3','0','0','1',},
				{'7','0','0','0','2','0','0','0','6',},
				{'0','6','0','0','0','0','2','8','0',},
				{'0','0','0','4','1','9','0','0','5',},
				{'0','0','0','0','8','0','0','7','9',},
			};
		
		LC036_ValidSudoku lc036 = new LC036_ValidSudoku();
		
		boolean isValid = lc036.isValidSudoku(sudoko);
		
		System.out.println("Sudoko is valid? " + isValid);
	}	
	
	//@Test
	public void testLC037(){
		
		trace();
		
	    int[][] sudoku = new int[][] {
 	           {5,3,0,0,7,0,0,0,0},
 	           {6,0,0,1,9,5,0,0,0},
 	           {0,9,8,0,0,0,0,6,0},
 	           {8,0,0,0,6,0,0,0,3},
 	           {4,0,0,8,0,3,0,0,1},
 	           {7,0,0,0,2,0,0,0,6},
 	           {0,6,0,0,0,0,2,8,0},
 	           {0,0,0,4,1,9,0,0,5},
 	           {0,0,0,0,8,0,0,7,9}
 	    };
		
		LC037_SudokuSolver lc037 = new LC037_SudokuSolver();
		
//		int row = 7;
//		int col = 7;
//		int value = 6;
//		
//		boolean isValid = lc041.isValid(sudoku, row, col, value);
//		System.out.println("Sudoko is valid? " + isValid);
		
		lc037.solveSudoku(sudoku);
	}	
	
	//@Test
	public void testLC038(){
		
		trace();
		
		int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30};
		
		LC038_CountAndSay lc038 = new LC038_CountAndSay();
		
		for (int i=0; i<input.length; i++) {
			System.out.println("#" + input[i] + ": " + lc038.countAndSay(input[i]));
		}
	}	
	
	//@Test
	public void testLC039(){
		
		trace();
		
		int [][] input = new int[][] {
//				{1},
//				{2,3,6,7},
				{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12},
		};
		
		int [] target = new int[] {
//				2,
//				7,
				27,
		};
		
		LC039_CombinationSum lc039 = new LC039_CombinationSum();
		
		for (int i=0; i<input.length; i++){
			List<List<Integer>> res = lc039.combinationSum(input[i], target[i]);
			LeetCodeUtils.printList(res);
		}		
	}
	
	//@Test
	public void testLC040(){
		
		trace();
		
		int [][] input = new int[][] {
//				{1,2,3},
//				{10,1,2,7,6,1,5},
				{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12},
		};
		
		int [] target = new int[] {
//				8,
				27,
		};
		
		LC040_CombinationSumII lc040 = new LC040_CombinationSumII();
		
		for (int i=0; i<input.length; i++){
			List<List<Integer>> res = lc040.combinationSum2(input[i], target[i]);
			LeetCodeUtils.printList(res);
		}		
	}
	
	//@Test
	public void testLC046(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,2,3,4},
//				{1,3,5,6},
//				{1,3,5,6},
//				{1,3,5,6},		
//				{1, 3},
		};
		
		LC046_Permutations lc046 = new LC046_Permutations();
		//LC046_PermutationsShort lc046 = new LC046_PermutationsShort();
		
		for (int i=0; i<input.length; i++) {		
			System.out.print("Input: ");
			LeetCodeUtils.printIntArray(input[i]);
			
			List<List<Integer>> res = lc046.permute(input[i]);
			
			for (List<Integer> tmp : res){
				LeetCodeUtils.printList(tmp);
			}
		}
	}
	
	//@Test
	public void testLC047(){
		int[][] input = new int[][] {
				{1,2,3},
//				{3,3,0,0,2,3,2},
//				{1,3,5,6},
//				{1,3,5,6},
//				{1,3,5,6},		
//				{1, 3},
		};
		
		trace();
		
		//LC047_Permutations2 lc047 = new LC047_Permutations2();
		LC047_Permutations2Short lc047 = new LC047_Permutations2Short();
		
		for (int i=0; i<input.length; i++) {		
			System.out.print("Input: ");
			LeetCodeUtils.printIntArray(input[i]);
			
			List<List<Integer>> res = lc047.permuteUnique(input[i]);
			
			for (List<Integer> tmp : res){
				LeetCodeUtils.printList(tmp);
			}
		}
	}
	
	//@Test
	public void testLC048(){
		int[][] input = new int[][] {
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25},
				{26,27,28,29,30},
				{31,32,33,34,35},
				
//				{ 1, 2, 3, 4},
//				{ 5, 6, 7, 8},
//				{ 9,10,11,12},				
//				{13,14,15,16},
				
//				{1,2,3},
//				{4,5,6},
//				{7,8,9},
				
//				{1,2},
//				{3,4},				
		};
		
		trace();
		
		LC048_RotateImage lc048 = new LC048_RotateImage();
		
		LeetCodeUtils.printIntArray2D(input);		
		lc048.rotate(input);
		System.out.println();
		LeetCodeUtils.printIntArray2D(input);		
	}
	
	//@Test
	public void testLC051(){
		
		trace();
		
		int n = 7;
		
		LC051_NQueens lc051 = new LC051_NQueens();	
		List<String[]> res = lc051.solveNQueens(n);
		
		for (int i = 0; i< res.size(); i++){
			System.out.println("Solution #" + (i+1));
			String[] s = res.get(i);
			for (int j=0; j<s.length; j++){
				System.out.println(s[j]);
			}
		}
	}
	
	//@Test
	public void testLC052(){
		
		trace();
		
		int n = 7;
		
		//LC052_NQueensII lc052 = new LC052_NQueensII();
		LC052_NQueensIII lc052 = new LC052_NQueensIII();
		int c = lc052.totalNQueens(n);
		
		System.out.println("Total distinct solutions for input: " + n + " is " + c);
	}
	
	//@Test
	public void testLC058(){
		
		trace();
		
		String[] s = new String[]{
				"",
				" ",
				"  ",
				"a",
				"abcdefg",
				"  abcdefg",
				"abcdefg  ",
				"abcd efg",
				"  abcd efg",
				"abcd efg ",
				"  abcd efg  ",
			};
			
		LC058_LengthOfLastWord lc058 = new LC058_LengthOfLastWord();
			
		for (String str : s) {
			System.out.println("Input: " + str + " length of last word is " + lc058.lengthOfLastWord(str));
		}
	}
	
	//@Test
	public void testLC060(){
		
		trace();
		
		int[] input = new int[] {1,2,3,4};
		int k = 6;
		
		LC046_Permutations lc046 = new LC046_Permutations();
		List<List<Integer>> res = lc046.permute(input);
		
		LC060_PermutationSeqMath lc060 = new LC060_PermutationSeqMath();
		System.out.println(lc060.getPermutation(k, 11));
		
//		for (int i=0; i<res.size(); i++){
//			System.out.print(i+1 + ": ");
//			System.out.print(lc060.getPermutation(input.length, i+1));
//			LeetCodeUtils.printList(res.get(i));
//		}
			
//		System.out.println("k=" + k + ": " + res.get(k-1));
//		System.out.println(lc060.getPermutation(input.length, k));
		
//		for (int k=1; k<=24; k++){
//			System.out.println("k=" + k + " " + lc060.getDigit(4, k));
//		}
		
//		54494

	}
		
	//@Test
	public void testLC061(){
		
		trace();
		
		int[][] input = new int[][] {
				{1,2,3,4,5},
//				{1,3,5,6},
//				{1,3,5,6},
//				{1,3,5,6},		
//				{1, 3},
		};
		
		int[] input2 = new int[] {
			5,
//			2,
//			7,
//			0,
//			2,
		};
		
		LC061_RotateList lc061 = new LC061_RotateList();
		
		for (int i=0; i<input.length; i++) {		
			ListNode head = lc061.rotateRight(LeetCodeUtils.buildList(input[i]), input2[i]);
			LeetCodeUtils.printlist(head);
		}
	}
	
	//@Test
	public void testLC062(){
		
		trace();
		
		int[][] input = new int[][] {
				{3, 7},
//				{1,3,5,6},
//				{1,3,5,6},
//				{1,3,5,6},		
//				{1, 3},
		};
		
		LC062_UniquePaths lc062 = new LC062_UniquePaths();
		
		for (int i=0; i<input.length; i++) {		
			int c = lc062.uniquePaths(input[i][0], input[i][1]);
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("# of unique paths is " + c);
		}
	}
	
	//@Test
	public void testLC063(){
		
		trace();
		
		int[][] input = new int[][] {
//				{0, 0},
//				{0, 1},				
//				{0},
//				{0, 0, 0},
//				{0, 1, 0},
//				{0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},

		};
		
		LC063_UniquePaths2 lc063 = new LC063_UniquePaths2();
		
		int c = lc063.uniquePathsWithObstacles(input);
		
		System.out.println("# of unique paths is " + c);
	}
	
	//@Test
	public void testLC064(){
		
		trace();
		
		int[][] input = new int[][] {
//				{0, 0},
//				{0, 1},				
//				{0},
//				{1, 1},
//				{2, 1},
//				{1, 1, 1},
//				{2, 2, 1},
//				{2, 2, 1},
				{1, 1, 1, 1, 1, 1, 1},
				{0, 0, 3, 1, 7, 0, 1},
				{2, 5, 0, 2, 0, 4, 1},

		};
		
		LC064_MinimumPathSum lc064 = new LC064_MinimumPathSum();
		
		int s = lc064.minPathSum(input);
		
		System.out.println("Minimum path sum is " + s);
	}
	
	//@Test
	public void testLC067(){
		
		trace();
		
		String[][] input = new String[][]{
				{"11", "1111"},
				{"100000", "100"},
				{"", "111"},
				{"111", "0"},
				{"1111", "1"}
			};
			
		LC067_AddBinary lc067 = new LC067_AddBinary();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Number 1:" + input[i][0] + " + Number 2: " + input[i][1] +
					" = " + lc067.addBinary(input[i][0],  input[i][1]));
		}				
	}
	
	//@Test
	public void testLC066(){
		
		trace();
		
		int [][] input = new int[][] {
				{1,2,3,4,5,6,7,8,9},
				{9,9,9},
				{0},
				{1},
				{}
		};
		
		LC066_PlusOne lc066 = new LC066_PlusOne();
		
		for (int[] in : input){
			System.out.println("Input array:");
			LeetCodeUtils.printIntArray(in);
			System.out.println("Output array:");
			LeetCodeUtils.printIntArray(lc066.plusOne(in));
		}
	}
	
	//@Test
	public void testLC070(){
		
		trace();
		
		int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30};
		
		LC070_ClimbingStairs lc070 = new LC070_ClimbingStairs();
		
		for (int i=0; i<input.length; i++) {
			System.out.println("#" + input[i] + ": " + lc070.climbStairs(input[i]));
		}
	}
	
	//@Test
	public void testLC071(){
		
		trace();

		String[] s = new String[]{
//				"//a/./b/../../c/",
//				"///home////",
//				"///",
//				"/home/../../..",
//				"/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///",
				"/.."
				
			};
			
		LC071_SimplifyPath lc071 = new LC071_SimplifyPath();
			
		for (String str : s) {
			System.out.println("Input: " + str + " simplified path is " + lc071.simplifyPath(str));
		}	
	}
	
	//@Test
	public void testLC077(){
		
		trace();
		
		int[] input = new int[] {
				3,
//				20,
//				20,
//				20,
//				20,
//				10,
//				{1,3,5,6},
//				{1,3,5,6},
//				{1,3,5,6},		
//				{1, 3},
		};
		
		int[] input2 = new int[] {
			3,
//			10,
//			10,
//			10,
//			10,
//			7,
//			2,
//			7,
//			0,
//			2,
		};
		
		LC077_Combinations lc077 = new LC077_Combinations();
		
		for (int i=0; i<input.length; i++) {		
			List<List<Integer>> res = lc077.combine(input[i], input2[i]);
			for (List<Integer> list : res){
				LeetCodeUtils.printList(list);
			}
		}
	}
	
	//@Test
	public void testLC078(){
		
		trace();
		
		int [][] input = new int[][] {
//				{4,1,0},
				{1,2,3,4},
//				{1,2,3,4,5},
		};

		LC078_Subsets lc078 = new LC078_Subsets();
		
		for (int i=0; i<input.length; i++){
			List<List<Integer>> res = lc078.subsets(input[i]);
			LeetCodeUtils.printList(res);
		}
		
	}
	
	//@Test
	public void testLC079(){
		
		trace();
		
		char[][] board = new char[][] {
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'},
//				{'a'},
//				{'a'},
//				{'a','a'},
				{'a','a','a','a'},
				{'a','a','a','a'},
				{'a','a','a','a'},
//				{'a','a'},
//				{'a','a'},
//				{'a','b'},
//				{'c','d'},
		};
		
		String[] words = {
//				"ABCCE",
//				"SEE",
//				"ABCB",
//				"aa",
//				"a",
				"aaaaaaaaaaaa",
//				"aaaaa",
//				"cdba",
		};
		
		for (String word : words) {
			LC079_WordSearch lc079 = new LC079_WordSearch();
			System.out.println("Word: " + word + " exists in baord? " + lc079.exist(board, word));
		}
	}
	
	//@Test
	public void testLC080(){
		
		trace();
		
		int [][] input = new int[][] {
				{1,1,1,1,1,2,2,2,3,3,3,5,5,5,6,6},
				{1,1,1,2,2,3},
				{1,1,2,2,3}		
		};
		
		LC080_RemoveDupArray2 lc080 = new LC080_RemoveDupArray2();
		
		for (int[] in : input){
			System.out.println("Input array:");
			LeetCodeUtils.printIntArray(in);
			System.out.println("Output list:");
			lc080.removeDuplicates(in);
			LeetCodeUtils.printIntArray(in);
		}
		
	}
	
	//@Test
	public void testLC083(){
		
		trace();
		
		int [][] input = new int[][] {
				{1,2,3,4,5,6,7,8,9},
				{1,2,2,2,3,5,6,6,7,9,9}		
		};
		
		LC083_RemoveDuplicates lc083 = new LC083_RemoveDuplicates();
		
		for (int[] in : input){
			System.out.println("Input list:");
			ListNode l1 = LeetCodeUtils.buildList(in);
			LeetCodeUtils.printlist(l1);
			System.out.println("Output list:");
			ListNode l2 = lc083.deleteDuplicates(l1);
			LeetCodeUtils.printlist(l2);
		}
		
	}
	
	//@Test
	public void testLC084(){
		
		trace();
		
		int [][] input = new int[][] {
				{1,2,3,3,3,4,4,5},
				{1,1,1,2,3},
				{1,1,2,2,3,3},
				{1,1,1,1,1,1},
				{1,1,1},
				{1,2,2},
//				{1,1},
//				{1,2},
//				{1},
		};
		
		LC084_RemoveDuplicates2 lc084 = new LC084_RemoveDuplicates2();
		
		for (int[] in : input){
			System.out.println("Input list:");
			ListNode l1 = LeetCodeUtils.buildList(in);
			LeetCodeUtils.printlist(l1);
			System.out.println("Output list:");
			ListNode l2 = lc084.deleteDuplicates(l1);
			LeetCodeUtils.printlist(l2);
		}
		
	}
	
	//@Test
	public void testLC088(){
		
		trace();
		
		int m = 12;
		int n = 8;
		
		int[] A = new int[m+n];
		int[] B = new int[n];
		
		for (int i=0; i < m; i++){
			A[i] = 2 * i + 100;
		}		
		LeetCodeUtils.printIntArray(A);
		
		for (int i=0; i < n; i++){
			B[i] = 2 * i + 1;
		}
		LeetCodeUtils.printIntArray(B);		
		
		LC088_MergeSortedArray lc088 = new LC088_MergeSortedArray();
		
		lc088.merge(A, m, B, n);
		
		LeetCodeUtils.printIntArray(A);		
	}
	
	//@Test
	public void testLC088_2(){
		
		trace();
			
		int[] A = new int[]{1,0};
		int[] B = new int[]{1};
				
		LC088_MergeSortedArray lc088 = new LC088_MergeSortedArray();
		
		lc088.merge(A, 1, B, 1);
		
		LeetCodeUtils.printIntArray(A);		
	}	
	
	//@Test
	public void testLC089(){
		
		trace();
		
		int n = 3;
		
		LC089_GrayCode lc089 = new LC089_GrayCode();
		List<Integer> res = lc089.grayCode2(n);
		
		LeetCodeUtils.printList(res);	
	}
	
	//@Test
	public void testLC090(){
		
		trace();
		
		int [][] input = new int[][] {
//				{1,2,3,4},
				{1,2,2,3},
//				{1,2,3,4,5},
		};
		
		LC090_SubsetsII lc090 = new LC090_SubsetsII();
		
		for (int i=0; i<input.length; i++){
			List<List<Integer>> res = lc090.subsetsWithDup2(input[i]);
			LeetCodeUtils.printList(res);
		}		
	}
	
	//@Test
	public void testLC093(){
		
		trace();
		
		String[] input = new String[]{
			    "25525511135",
			    "172162541",
			    "123",
			    "1111",
			    "12345",
			    "12345678",
			    "010010",
			};
		
		LC093_RestoreIPAddress lc093 = new LC093_RestoreIPAddress();
		
		for (String s : input){
			System.out.println("Input: " + s);
			List<String> res = lc093.restoreIpAddresses(s);		
			LeetCodeUtils.printList(res);
		}		
	}
	
	//@Test
	public void testLC118(){
		
		trace();
		
		LC118_PascalsTriangle lc118 = new LC118_PascalsTriangle();
		
		List<List<Integer>> res = lc118.generate(5);
		
		for (List<Integer> list : res) {
			LeetCodeUtils.printList(list);
		}
		
	}
	
	//@Test
	public void testLC120(){
		
		trace();
		
		int [][] input = new int[][] {
//				{-1,0,0},
//				{2,3,0},
//				{1,-1,-3}
				{2,0,0,0},
				{3,4,0,0},
				{6,5,7,0},
				{4,1,8,3}
		};
		
		LC120_Triangle lc120 = new LC120_Triangle();
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		
		for (int i=0; i<input.length; i++){
			List<Integer> row = new ArrayList<Integer>();
			
			for (int j=0; j<input[i].length; j++){
				if (input[i][j]!=0){
					row.add(input[i][j]);
				}
			}
			
			triangle.add(row);
		}
		
		System.out.println("Minimum sum of input triangle is: " + lc120.minimumTotal(triangle));
	}
	
	//@Test
	public void testLC125(){
		
		trace();

		String[] s = new String[]{
		    "1a2",
			"A man, a plan, a canal: Panama",
		};
			
		LC125_ValidPalindrome lc125 = new LC125_ValidPalindrome();
			
		for (String str : s) {
			System.out.println("Input: " + str + " is a " + lc125.isPalindrome(str));
		}	
	}
	
	@Test
	public void testLC126(){
		
		trace();

		String[] start = new String[]{
			"hit",
			//"qa",
		};
		
		String[] end = new String[]{
			"cog",
			//"sq",
		};
		
		String[][] d = new String[][] {
			{"hot", "dot", "dog", "lot", "log", "cog"},
			//{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"},
		};

		//LC126_WordLadderII lc126 = new LC126_WordLadderII();
		LC126_WordLadderII_LC lc126 = new LC126_WordLadderII_LC();
			
		for (int i=0; i< start.length; i++){
			
			Set<String> dict = new HashSet<String>();
			String[] dStr = d[i];
			for (int j=0; j<dStr.length; j++){
				dict.add(dStr[j]);
			}
			
			List<List<String>> res = lc126.findLadders(start[i], end[i], dict);
			for (List<String> l : res){
				LeetCodeUtils.printList(l);
			}
		}
	}
	
	//@Test
	public void testLC131(){
		
		trace();

		String[] s = new String[]{
			"bb",
		    "aab",
		};
			
		LC131_PalindromePartition lc131 = new LC131_PalindromePartition();
			
		for (String str : s) {
			System.out.println("Input: " + str);
			List<List<String>> res = lc131.partition(str);
			LeetCodeUtils.printList(res);
		}	
	}
	
	//@Test
	public void testLC139(){
		
		trace();
		
		String[][] dict = new String[][]{
				{"a", "b"},
				{"good", "leet", "code", "today"},
				{"cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb"},
				{"kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"},
				{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},			
		};
		
		String[] words = new String[] {
			"ab",
			"codeleetgood",
			"bccdbacdbdacddabbaaaadababadad",
			"fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami",
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",			
		};
		
		for (int i=0; i<words.length; i++){			
			
			Set<String> dictSet = new HashSet<String>(Arrays.asList(dict[i]));  
			
			LC139_WordBreak lc139 = new LC139_WordBreak();
			
			boolean breakable = lc139.wordBreak(words[i], dictSet);
			
			LeetCodeUtils.printStrArray(dict[i]);
			System.out.println("word: " + words[i] + ", breakable? " + breakable);	
			
			System.out.println("# if recursions: " + lc139.cnt);
		}
		
		
	}
	
	//@Test
	public void testLC140(){
		
		trace();
		
		String[][] dict = new String[][]{
				{"a", "b"},
				{"cat", "cats", "and", "sand", "dog"},
				{"cat", "cats", "and", "sand", "dog", "bark", "dark"},
				{"o","b","gbdfgiokkfnhl","glibjohcmd","bblcnhelanckn","mflabckflflja","mgda","oheafhajjo","cc","cffalholojikojm","haljiamccabh","gjkdlonmhdacd","ee","bc","mjj","fdlmmbhij","nn","jiaaifedaihn","nhligg","hooaglldlei","hajhebh","ebijeeh","me","eibm","ekkobhajgkem","ohaofonhjakc","n","kjjogm","mhn","odcamjmodie","edmagbkejiocacl","kcbfnjialef","lhifcohoe","akgnn","fbgakjhjb","belggjekmn","oinedhhnolc","ddekcnag","oneoakldakalb","bodnokemafkhkhf","dkefeddjdnab","gflcngff","fgnfmbcogmojgm","ad","jadhganf","lojckbdfj","gadkaoe","jdam","ljjndlnednnombl","aggegbnngohbgga"},
				{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},				
				{"aaaa","aa","a"},
		};
		
		String[] words = new String[] {
			"ab",
			"catsanddog",
			"darkcatsanddogbark",
			"aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam",
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
			"aaaaa",
		};
		
//		LC140_WordBreak2 lc140 = new LC140_WordBreak2();
		
		for (int i=0; i<words.length; i++){			
			
			Set<String> dictSet = new HashSet<String>(Arrays.asList(dict[i]));  		
			LC140_WordBreak2 lc140 = new LC140_WordBreak2();
			List<String> list = lc140.wordBreak(words[i], dictSet);
			
			System.out.println("Dict: ");
			LeetCodeUtils.printStrArray(dict[i]);
			System.out.println("Phrase: " + words[i]);
			System.out.println("Solutions: ");
			for (String s : list){
				System.out.println(s + " ");
			}		
//			System.out.println("# if recursions: " + lc140.count);
//			System.out.println("# if cache hits: " + lc140.count2);
		}
	}
	
	/**
	 * 
	 * 1->2->3->4->5->6->7->8->9->10->11->12
	 *                            |        |
	 *                            15<-14<-13
	 * 
	 * 
	 */
	//@Test
	public void testLC141(){
		
		trace();
		
		int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};		
		
		ListNode head = LeetCodeUtils.buildList(list);
		
		ListNode p1 = head;
		while (p1.val!=15){
			p1 = p1.next;
		}
		
		ListNode p2 = head;
		while (p2.val!=10){
			p2 = p2.next;
		}
		
		//p1.next = p2;
		
//		ListNode p3 = head;
//		int count = 0;
//		while (true){				
//			if (count>=26) break;			
//			System.out.print(p3.val + " ");			
//			p3 = p3.next;			
//			count++;
//		}
//		System.out.println();
		
		LC141_LinkedListCycle lc141 = new LC141_LinkedListCycle();
		System.out.print("Linked list has cycle? " + lc141.hasCycle(head));	
	}
	
	/**
	 * 
	 * 1->2->3->4->5->6->7->8->9->10->11->12
	 *                            |        |
	 *                            15<-14<-13
	 * 
	 * 
	 */
	//@Test
	public void testLC142(){
		
		trace();
		
		int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};		
		
		ListNode head = LeetCodeUtils.buildList(list);
		
		ListNode p1 = head;
		while (p1.val!=15){
			p1 = p1.next;
		}
		
		ListNode p2 = head;
		while (p2.val!=10){
			p2 = p2.next;
		}
		
		p1.next = p2;
		
		ListNode p3 = head;
		int count = 0;
		while (true){				
			if (count>=26) break;			
			System.out.print(p3.val + " ");			
			p3 = p3.next;			
			count++;
		}
		System.out.println();
		
		LC142_LinkedListCycle2 lc142 = new LC142_LinkedListCycle2();
		ListNode loopStart = lc142.detectCycle(head);
		
		if (loopStart!=null){
			System.out.print("Loop starting node is " + loopStart.val);
		}
		else {
			System.out.print("Not a cycling list");
		}
	}
	
	//@Test
	public void testLC142_2(){
		
		trace();
		
		int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};		
		
		ListNode head = LeetCodeUtils.buildList(list);
		
		ListNode tail = head;
		while (tail.val!=15){
			tail = tail.next;
		}
		
		tail.next = tail;
		
		LC142_LinkedListCycle2 lc142 = new LC142_LinkedListCycle2();
		ListNode loopStart = lc142.detectCycle(head);
		
		if (loopStart!=null){
			System.out.print("Loop starting node is " + loopStart.val);
		}
		else {
			System.out.print("Not a cycling list");
		}
	}
	
	//@Test
	public void testLC142_3(){
		
		trace();
		
		ListNode head = new ListNode(1);
		ListNode tail = new ListNode(2);
		head.next = tail;
		tail.next = head;
		
		LC142_LinkedListCycle2 lc142 = new LC142_LinkedListCycle2();
		ListNode loopStart = lc142.detectCycle(head);
		
		if (loopStart!=null){
			System.out.print("Loop starting node is " + loopStart.val);
		}
		else {
			System.out.print("Not a cycling list");
		}
	}
	
	//@Test
	public void testLC151(){
		
		trace();
		
		String[] input = new String[]{
				"the sky is blue",
				" ",
				"sky"
		};
		
		LC151_ReverseWordsInString lc151 = new LC151_ReverseWordsInString();
		
		for (int i=0; i<input.length; i++){
			System.out.println("input: " + input[i] + "->output: " + lc151.reverseWords(input[i]));
		}
	}
	
	//@Test
	public void testLC155(){
		
		trace();
		
		LC155_MinStack lc155 = new LC155_MinStack();
		
//		lc155.push(10);		// main: [10], min: [10]
//		lc155.push(9);		// main: [9, 10], min: [9, 10]
//		lc155.push(12); 	// main: [12, 9, 10], min: [9, 10]
//		lc155.pop();		// main: [9, 10], min: [9, 10]
//		lc155.push(5);		// main: [5, 9, 10], min: [5, 9, 10]
//		lc155.push(7);		// main: [7, 5, 9, 10], min: [5, 9, 10]
//		System.out.println("top of stack is " + lc155.top() + " min is " + lc155.getMin());
		
		lc155.push(395);
		System.out.println(lc155.getMin());
		System.out.println(lc155.top());
		System.out.println(lc155.getMin());
		lc155.push(276);
		lc155.push(29);
		System.out.println(lc155.getMin());
		lc155.push(-482);
		System.out.println(lc155.getMin());
		lc155.pop();
		lc155.push(-108);
		lc155.push(-251);
		System.out.println(lc155.getMin());
	}
	
	//@Test
	public void testLC160(){
		
		trace();
		
		LC160_IntersectionLinkedLists lc160 = new LC160_IntersectionLinkedLists();
		
		int[] a1 = new int[]{1,2,3,4,5};
		int[] a2 = new int[]{6,7,8};
		int[] a3 = new int[]{9,10,11,12,13};
		
		ListNode head1 = LeetCodeUtils.buildList(a1);
		ListNode head2 = LeetCodeUtils.buildList(a2);
		ListNode head3 = LeetCodeUtils.buildList(a3);
		
		ListNode r1 = lc160.getIntersectionNode(head2, head3);
		LeetCodeUtils.printlist(r1);
		
		ListNode tail2 = LeetCodeUtils.findTail(head2);
		ListNode tail3 = LeetCodeUtils.findTail(head3);
		
		tail2.next = head1;
		tail3.next = head1;
		
		ListNode r2 = lc160.getIntersectionNode(head2, head3);
		LeetCodeUtils.printlist(r2);
	}
	
	//@Test
	public void testLC165(){
		
		trace();
		
		String[][] input = new String[][]{
				{"1.0", "0.1"},
				{"1.0.0", "1.0"},
				{"1", "0"},
				{"0.1", "1.1"},
				{"1.21", "1.21"},
				{"22.5", "13.7"},
				{"1.1", "1.01.0"},
				{"19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000", "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"},
		};
		
		LC165_CompareVersion lc165 = new LC165_CompareVersion();
		
		for (int i=0; i<input.length; i++){
			System.out.println("input: " + input[i][0] + " " + input[i][1] + ": " +
					lc165.compareVersion(input[i][0], input[i][1]));
		}
	}
	
	//@Test
	public void testLC168(){
		
		trace();
		
		int[] input = new int[]{
			1,
			2,
			3,
			26,
			27,
			28,
			52,
			53,
			78,
			79,
			675,
			676,
			677,
			17575,
			17576,
			17577,
			
		};
		
		LC168_ExcelSheetColumnTitle lc168 = new LC168_ExcelSheetColumnTitle();
		
		for (int i=0; i<input.length; i++){
			//System.out.println("input: " + input[i] + "->title: " + lc168.convertToTitle(input[i]));
			System.out.println("\"" + lc168.convertToTitle(input[i]) + "\",");
		}
	}	
	
	//@Test
	public void testLC171(){
		
		trace();
		
		String[] input = new String[]{
				"A",
				"B",
				"C",
				"Z",
				"AA",
				"AB",
				"AZ",
				"BA",
				"BZ",
				"CA",
				"YY",
				"YZ",
				"ZA",
				"YYY",
				"YYZ",
				"YZA",

		};
		
		LC171_ExcelSheetColumnNumber lc171 = new LC171_ExcelSheetColumnNumber();
		
		for (int i=0; i<input.length; i++){
			System.out.println("input: " + input[i] + "->title: " + lc171.titleToNumber(input[i]));
		}
	}	
	
	//@Test
	public void testLC172(){
		
		trace();
		
		int[] input = new int[]{
			0,
			1,
			4,
			5,
			9,
			10,
			15,
			20,
			21,
			25,
			50,
			75,
			76,
			100,
			500,
			2147483647,			
		};
		
		LC172_FactorialTrailingZeros lc172 = new LC172_FactorialTrailingZeros();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Input=" + input[i] + " , output=" + lc172.trailingZeroes(input[i]));
		}
	}	
	
	//@Test
	public void testLC179(){
		
		trace();
		
		int [][] input = new int[][] {
				{0},
				{0,0},
				{0,0,0},
				{3, 30, 34, 5, 9},
				{128,12},
				{121,12},
				{123,12},
				{3, 30, 300, 34, 5, 9},
//				{1,2,2,3},
//				{1,2,3,4,5},
		};
		
		LC179_LargestNumber lc179 = new LC179_LargestNumber();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			System.out.println("largest number " + lc179.largestNumber(input[i]));
		}		
	}
	
	//@Test
	public void testLC189(){
		
		trace();
		
		int [][] input = new int[][] {
				{1,2,3,4,5,6,7},
				{1,2,3,4,5,6},
//				{0,0},
//				{0,0,0},
		};
		
		int [] input2 = new int[] {
				3,
				3
		};
		
		LC189_RotateArray lc189 = new LC189_RotateArray();
		
		for (int i=0; i<input.length; i++){
			LeetCodeUtils.printIntArray(input[i]);
			lc189.rotate(input[i], input2[i]);
			LeetCodeUtils.printIntArray(input[i]);
		}		
	}	
	
	//@Test
	public void testLC190(){
		
		trace();
		
		long[] input = new long[]{
			0,
			1,
			43261596,
			2147483648l,
			2,
			3,
			26,
			27,
			28,
			52,
			53,
			78,
			79,
			675,
			676,
			677,
			17575,
			17576,
			17577,
			
		};
		
		LC190_ReverseBits lc190 = new LC190_ReverseBits();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Input=" + input[i] + " , output=" + lc190.reverseBits(input[i]));
		}
	}	

	//@Test
	public void testLC191(){
		
		trace();
		
		int[] input = new int[]{
			0,
			1,
			2,
			3,
			4,
			5,
			43261596,
			2147483647,
			2,
			3,
			26,
			27,
			28,
			52,
			53,
			78,
			79,
			675,
			676,
			677,
			17575,
			17576,
			17577,
			
		};
		
		LC191_NumberOfOneBits lc191 = new LC191_NumberOfOneBits();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Input=" + input[i] + " , output=" + lc191.hammingWeight(input[i]));
		}
	}		
	
	@Test
	public void testTreeUtils(){
		
		trace();
		
		Random ran = new Random();
		
		int size = 20;
		
		List<Integer> list = new ArrayList<Integer>();
		
		while (list.size() <= size){
			int i = ran.nextInt(100);
			if (!list.contains(i)){
				list.add(i);
			}
		}
				
		int[] num = new int[size];
		for (int i=0; i<size; i++){
			num[i] = list.get(i);
		}
			
//		System.out.println("Input array:");
//		LeetCodeUtils.printIntArray(num);
		
		TreeNode root = LeetCodeUtils.buildBalancedBST(num);	
		LeetCodeUtils.printTreeByLevel(root);
		
//		System.out.println("Level Order");
//		LeetCodeUtils.printTreeLevelOrder(root);
		
		System.out.println("Serilize: ");
		System.out.println(LeetCodeUtils.serilizeBinaryTree(root));
	}
}


