package com.leetcode.jyang;

import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class LC200_TestSuite {
	
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
	
	//@Test
	public void testLC006() {
		
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
		
		int[] num = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		
		LC015_3Sum lc015 = new LC015_3Sum();
		
		Arrays.sort(num);
		
		int i = lc015.binarySearch(num, 0, num.length-1, 2);
		
		System.out.println(i);
	}
	
	//@Test
	public void testLC015(){
		
		int[][] input = new int[][] {
//			{-1, 0, 1, 2, -1, -4},
//			{-1, 0, 1},
//			{0, 0, 0},
//			{1, 1, 1},
//			{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6},
			{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6},				
		};
			
		LC015_3Sum lc015 = new LC015_3Sum();
		
		for (int i=0; i<input.length; i++){
			List<List<Integer>> result = lc015.threeSum(input[i]);
			System.out.println("Results for input set: " + i + "->" + result.size());
			for (List<Integer> r : result){
				for (Integer in : r){
					System.out.print( in + ", ");
				}
				System.out.println();
			}

		}
	}
	
	//@Test
	public void testLC019(){
		
		int[] input = new int[]{1,2,3,4,5};
		int n = 7;
		
		ListNode head = LeetCodeUtils.buildList(input);
		
		LC019_RemoveNthNode lc019 = new LC019_RemoveNthNode();
		
		head = lc019.removeNthFromEnd(head, n);
		
		LeetCodeUtils.printlist(head);
	}
	
	//@Test
	public void testLC020(){
		
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
		ListNode l1 = LeetCodeUtils.buildList(new int[]{1,3,4,6,9,23,28});	
		ListNode l2 = LeetCodeUtils.buildList(new int[]{1,2,4,7,10,25,28});
		
		LC021_MergeTwoLists lc021 = new LC021_MergeTwoLists();
		
		LeetCodeUtils.printlist(lc021.mergeTwoLists(l1, l2));	
	}	
	
	@Test
	public void testLC025(){
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
		
		LC027_RemoveElement lc027 = new LC027_RemoveElement();
		
		int[] A = new int[]{1,1,2,3,4,4,5,6,7,7,8,8,9};
		
		lc027.removeElement(new int[]{1,1,2,3,4,4,5,6,7,7,8,8,9}, 4);
		
		LeetCodeUtils.printIntArray(A);
	}
	
	//@Test
	public void testLC028(){
		
		//String haystack = "The quick brown fox jumps over the lazy dog";
		//String needle = "dog?";
		
		//String haystack = "mississippi";
		//String needle = "issipi";
		
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
	public void testLC037_1(){
		
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
	public void testLC037(){
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
		
		LC037_ValidSudoku lc037 = new LC037_ValidSudoku();
		
		boolean isValid = lc037.isValidSudoku(sudoko);
		
		System.out.println("Sudoko is valid? " + isValid);
		
	}	
	
	//@Test
	public void testLC038(){
		
		int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30};
		
		LC038_CountAndSay lc038 = new LC038_CountAndSay();
		
		for (int i=0; i<input.length; i++) {
			System.out.println("#" + input[i] + ": " + lc038.countAndSay(input[i]));
		}
	}	
	
	//@Test
	public void test058(){
		
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
	public void test067(){
		
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
	public void test066(){
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
	public void test083(){
		
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
	public void test084(){
		
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
}


