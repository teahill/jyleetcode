package com.leetcode.jyang;

/**
 * This JUnit suite contains unit tests for LeetCode problems 1 to 100.
 *
 * @author jyang
 *
 */

import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class LC999_TestSuite1 {
	
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
	public void testLC094(){
		
		trace();
		
		LC094_InorderTraversal lc094 = new LC094_InorderTraversal();
		
		TreeNode root = LeetCodeTreeUtils.generateBST(15, 20);
		LeetCodeTreeUtils.printTreeByLevel(root);
		LeetCodeTreeUtils.printTreeInOrder(root);
		
		List<Integer> res = lc094.inorderTraversal(root);
		System.out.println("\nresuts:");
		LeetCodeUtils.printList(res);
	}
	
	/*              5
	 *            /    \
	 *           4      8
	 *          / \    / \
	 *       11   9   13   6
	 *      / \        \
	 *     7   2      1
	 */       
	@Test
	public void testLC094_2(){
		
		trace();
		
		LC094_InorderTraversal lc094 = new LC094_InorderTraversal();
		
		String tree = "11,6,15,1,9,13,18,0,3,8,10,12,14,17,19,";
		//String tree = "5,4,8,11,#,13,4,7,2,#,#,#,1";
		TreeNode root = LeetCodeTreeUtils.deserilizeBinaryTree(tree);
		LeetCodeTreeUtils.printTreeByLevel(root);
		LeetCodeTreeUtils.printTreeInOrder(root);
		
		List<Integer> res = lc094.inorderTraversal(root);
		System.out.println("\nresuts:");
		LeetCodeUtils.printList(res);
	}
	
	//@Test
	public void testLC098(){
		
		trace();
		
		int size = 20;
		int maxVal = 100;
		
		LC098_ValidateBST lc098 = new LC098_ValidateBST();
		
		int[] num = new int[]{1,1};
		TreeNode r = LeetCodeTreeUtils.buildBalancedBST(num);	
		LeetCodeTreeUtils.printTreeByLevel(r);
		System.out.println("Is this a valid BST? " + lc098.isValidBST(r));
		
		TreeNode root = LeetCodeTreeUtils.generateBST(size, maxVal);	
		LeetCodeTreeUtils.printTreeByLevel(root);
		System.out.println("Is this a valid BST? " + lc098.isValidBST(root));
		
		String tStr = LeetCodeTreeUtils.serilizeBinaryTree(root);
		
		int i;		
		for (i=maxVal/2; i>=0; i--){
			if (tStr.indexOf(String.valueOf(i))>=0)	break;
		}
		
		String tStr2 = tStr.replace(String.valueOf(i), String.valueOf(100+i));
		TreeNode root2 = LeetCodeTreeUtils.deserilizeBinaryTree(tStr2);
		
		LeetCodeTreeUtils.printTreeByLevel(root2);
		System.out.println("Is this a valid BST? " + lc098.isValidBST(root2));
	}
	
	//@Test
	public void testLC100(){
		
		trace();
		
		int size = 20;
		int maxVal = 100;
		
		LC100_SameTree lc100 = new LC100_SameTree();
		
		TreeNode p = LeetCodeTreeUtils.generateBST(size, maxVal);	
		LeetCodeTreeUtils.printTreeByLevel(p);
		TreeNode q = LeetCodeTreeUtils.generateBST(size, maxVal);	
		LeetCodeTreeUtils.printTreeByLevel(q);
		
		System.out.println("Same tree? " + lc100.isSameTree(p, q));
		System.out.println("Same tree? " + lc100.isSameTree(p, p));
		System.out.println("Same tree? " + lc100.isSameTree(null, null));
	}
}


