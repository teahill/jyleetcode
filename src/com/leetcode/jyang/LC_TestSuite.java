package com.leetcode.jyang;

import org.junit.*;

import static org.junit.Assert.*;

public class LC_TestSuite {
	
    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeClass - oneTimeSetUp");
    }
 
    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterClass - oneTimeTearDown");
    }
 
    @Before
    public void setUp() {
        System.out.println("@Before - setUp");
    }
 
    @After
    public void tearDown() {
        System.out.println("@After - tearDown");
    }
	
	@Test
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
	
	@Test
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
