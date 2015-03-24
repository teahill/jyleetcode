package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	//@Test
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
	public void testLC034(){
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
	public void testLC061(){
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
	public void test070(){
		
		int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30};
		
		LC070_ClimbingStairs lc070 = new LC070_ClimbingStairs();
		
		for (int i=0; i<input.length; i++) {
			System.out.println("#" + input[i] + ": " + lc070.climbStairs(input[i]));
		}
	}
	
	//@Test
	public void test071(){

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
	public void test080(){
		
		int [][] input = new int[][] {
				{1,1,1,2,2,2,3,3,3,5,5,5,6,6},
				{1,1,1,2,2,3},
				{1,1,2,2,3}		
		};
		
		LC080_RemoveDupArray2 lc080 = new LC080_RemoveDupArray2();
		
		for (int[] in : input){
			System.out.println("Input array:");
			LeetCodeUtils.printIntArray(in);
			System.out.println("Output list:");
			lc080.removeDuplicates2(in);
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
	
	//@Test
	public void test118(){
		
//		int [][] input = new int[][] {
//				{1},
//				{1,2,1},
//				{1,3,3,1},
//				{1,4,6,4,1}
//		};
		
		LC118_PascalsTriangle lc118 = new LC118_PascalsTriangle();
		
		List<List<Integer>> res = lc118.generate(5);
		
		for (List<Integer> list : res) {
			LeetCodeUtils.printList(list);
		}
		
	}
	
	//@Test
	public void test120(){
		
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
	public void test125(){

		String[] s = new String[]{
		    "1a2",
			"A man, a plan, a canal: Panama",
		};
			
		LC125_ValidPalindrome lc125 = new LC125_ValidPalindrome();
			
		for (String str : s) {
			System.out.println("Input: " + str + " is a " + lc125.isPalindrome(str));
		}	
	}
	
	//@Test
	public void test139(){
		
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
	public void test140(){
		
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
	public void test141(){
		
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
	public void test142(){
		
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
	public void test142_2(){
		
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
	
	@Test
	public void test142_3(){
		
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
	public void test151(){
		
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
	public void test168(){
		
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
	public void test171(){
		
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
}


