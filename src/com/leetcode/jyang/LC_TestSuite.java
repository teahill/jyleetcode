package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

public class LC_TestSuite {
	
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
	
	@Test
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
}
