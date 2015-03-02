package com.leetcode.jyang;

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
	public void testLC_006() {
		
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
	
	@Test
	public void testLC_011(){
		
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
	public void testLC_012() {
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
	public void testLC_014(){
		
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
}
