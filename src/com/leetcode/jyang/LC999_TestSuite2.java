package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.*;

/**
 * This JUnit suite contains unit tests for LeetCode problems 101 to 200.
 *
 * @author jyang
 *
 */
public class LC999_TestSuite2 {
	
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
	
	@Test
	public void testLC101(){
		
		trace();
		
		LC101_SymmetricTree lc101 = new LC101_SymmetricTree();
		
		String tree1 = "1,#,2";
		String tree2 = "1,2,2,3,#,#,3";
		
		TreeNode root1 = LeetCodeTreeUtils.deserilizeBinaryTree(tree1);
		TreeNode root2 = LeetCodeTreeUtils.deserilizeBinaryTree(tree2);
		
		LeetCodeTreeUtils.printTreeByLevel(root1);
		LeetCodeTreeUtils.printTreeByLevel(root2);
		
		System.out.println("Tree 1 is symmetric? " + lc101.isSymmetric(root1));
		System.out.println("Tree 2 is symmetric? " + lc101.isSymmetric(root2));
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
	
	//@Test
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
	
	//@Test
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
		
		TreeNode root = LeetCodeTreeUtils.buildBalancedBST(num);	
		LeetCodeTreeUtils.printTreeByLevel(root);
		
//		System.out.println("Level Order");
//		LeetCodeUtils.printTreeLevelOrder(root);
		
		System.out.println("Serilize: ");
		String treeStr = LeetCodeTreeUtils.serilizeBinaryTree(root);
		System.out.println(treeStr);
		
		System.out.println("Deserilize: ");
		TreeNode root2 = LeetCodeTreeUtils.deserilizeBinaryTree(treeStr);
		
		LeetCodeTreeUtils.printTreeByLevel(root2);	
		System.out.println("Level Order");
		LeetCodeTreeUtils.printTreeLevelOrder(root2);	
	}
}


